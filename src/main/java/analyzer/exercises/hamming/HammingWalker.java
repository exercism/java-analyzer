package analyzer.exercises.hamming;

import com.github.javaparser.Range;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.CharLiteralExpr;
import com.github.javaparser.ast.expr.LambdaExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithRange;
import com.github.javaparser.ast.stmt.*;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class HammingWalker implements Consumer<ClassOrInterfaceDeclaration> {
    private ClassOrInterfaceDeclaration hammingClass;
    private final Set<ConstructorDeclaration> constructors = new HashSet<>();
    private ConstructorDeclaration constructor;
    private final Map<String, List<MethodDeclaration>> methods = new HashMap<>();
    private final Set<String> methodsCalledByConstructor = new HashSet<>();
    private boolean constructorHasIfStatements;
    private boolean constructorThrowsIllegalArgumentDirectly;
    private boolean constructorMayCalculateDistanceDirectly;
    private final Set<String> methodsCalledByGetHammingDistance = new HashSet<>();
    private boolean getHammingDistanceMayCalculateDistanceDirectly;

    @Override
    public void accept(ClassOrInterfaceDeclaration node) {
        if (node.getNameAsString().equals("Hamming")) {
            hammingClass = node;
            walkHammingClass();
        }
    }

    private void walkHammingClass() {
        methods.putAll(getMethodsByName());
        constructors.addAll(hammingClass.getConstructors());

        findConstructor().ifPresent(this::walkConstructor);

        findGetHammingDistanceMethod().ifPresent(this::walkGetHammingDistanceMethod);

    }

    private Map<String, List<MethodDeclaration>> getMethodsByName() {
        return hammingClass.findAll(MethodDeclaration.class)
                .stream()
                .collect(Collectors.groupingBy(MethodDeclaration::getNameAsString));
    }

    private Optional<ConstructorDeclaration> findConstructor() {
        return hammingClass.getConstructorByParameterTypes(String.class, String.class);
    }

    private void walkConstructor(ConstructorDeclaration foundConstructor) {
        constructor = foundConstructor;

        constructor.getBody().getStatements().forEach(this::walkConstructorStatement);
    }

    private void walkConstructorStatement(Statement statement) {
        if (statement.isIfStmt()) {
            constructorHasIfStatements = true;
        }

        if (isThrowNewIllegalArgument(statement)) {
            constructorThrowsIllegalArgumentDirectly = true;
        }

        if (statementMayCalculateHammingDistance(statement)) {
            constructorMayCalculateDistanceDirectly = true;
        }

        getMethodCallNames(statement)
                .forEach(methodName ->
                        recursivelyAddMethodsCalled(methodName, methodsCalledByConstructor));
    }

    private boolean isThrowNewIllegalArgument(Statement statement) {
        return statement.findAll(ThrowStmt.class).stream()
                .anyMatch(this::isCreatingIllegalArgumentException);
    }

    private boolean isCreatingIllegalArgumentException(ThrowStmt throwStmt) {
        return throwStmt.getExpression().isObjectCreationExpr()
                && throwStmt
                .getExpression()
                .asObjectCreationExpr()
                .getType()
                .getNameAsString()
                .equals("IllegalArgumentException");
    }

    private boolean isMethodCall(Statement statement) {
        return !statement.findAll(MethodCallExpr.class).isEmpty();
    }

    private Stream<String> getMethodCallNames(Statement statement) {
        return statement.findAll(MethodCallExpr.class).stream()
                .map(MethodCallExpr::getNameAsString)
                .distinct();
    }

    private Optional<MethodDeclaration> findGetHammingDistanceMethod() {
        return methods.get("getHammingDistance").stream()
                // we only care about the one with no parameters
                .filter(method -> method.getParameters().isEmpty())
                .findFirst();
    }

    private void walkGetHammingDistanceMethod(MethodDeclaration getHammingDistanceMethod) {
        getHammingDistanceMethod.getBody().ifPresent(this::walkGetHammingDistanceMethod);
    }

    private void walkGetHammingDistanceMethod(BlockStmt body) {
        body.getStatements().forEach(this::walkGetHammingDistanceStatement);
    }

    private void walkGetHammingDistanceStatement(Statement statement) {
        if (statementMayCalculateHammingDistance(statement)) {
            getHammingDistanceMayCalculateDistanceDirectly = true;
        }

        getMethodCallNames(statement)
                .forEach(methodName ->
                        recursivelyAddMethodsCalled(methodName, methodsCalledByGetHammingDistance));
    }

    private void recursivelyAddMethodsCalled(
            String methodName,
            Set<String> methodsCalled) {
        if (methodsCalled.contains(methodName)) {
            return;
        }
        methodsCalled.add(methodName);

        getMethodsCalledBy(methodName)
                .distinct()
                .forEach(calledMethod ->
                        recursivelyAddMethodsCalled(calledMethod, methodsCalled));
    }

    private Stream<String> getMethodsCalledBy(String methodName) {
        return methods.getOrDefault(methodName, List.of()).stream()
                .flatMap(this::getMethodsCalledBy);
    }

    private Stream<String> getMethodsCalledBy(MethodDeclaration method) {
        return method.getBody()
                .map(this::getMethodsCalledBy)
                .orElse(Stream.of());
    }

    private Stream<String> getMethodsCalledBy(BlockStmt body) {
        return body.getStatements().stream()
                .filter(this::isMethodCall)
                .flatMap(this::getMethodCallNames);
    }

    public boolean hasConstructor() {
        return constructor != null;
    }

    public boolean constructorHasIfStatements() {
        return constructorHasIfStatements;
    }

    public boolean constructorHasMethodCalls() {
        return !methodsCalledByConstructor.isEmpty();
    }

    public boolean constructorThrowsIllegalArgument() {
        return constructorThrowsIllegalArgumentDirectly
                || constructorThrowsIllegarArgumentIndirectly();
    }

    private boolean constructorThrowsIllegarArgumentIndirectly() {
        return methodsCalledByConstructor.stream()
                .anyMatch(this::methodThrowsIllegalArgumentException);
    }

    private boolean methodThrowsIllegalArgumentException(String methodName) {
        return methods.getOrDefault(methodName, List.of()).stream()
                .anyMatch(this::methodThrowsIllegalArgumentException);
    }

    private boolean methodThrowsIllegalArgumentException(MethodDeclaration method) {
        return method.getBody()
                .map(this::methodBodyThrowsIllegalArgumentException)
                .orElse(false);
    }

    private boolean methodBodyThrowsIllegalArgumentException(BlockStmt body) {
        return body.getStatements().stream()
                .anyMatch(this::isThrowNewIllegalArgument);
    }

    public boolean constructorMayCalculateDistance() {
        return constructorMayCalculateDistanceDirectly
                || constructorCallsMethodThatMayCalculateDistance();
    }

    private boolean constructorCallsMethodThatMayCalculateDistance() {
        return methodsCalledByConstructor.stream()
                .anyMatch(this::methodMayCalculateHammingDistance);
    }

    public boolean getHammingDistanceMethodMayCalculateDistance() {
        return getHammingDistanceMayCalculateDistanceDirectly
                || getHammingDistanceCallsMethodThatMayCalculateDistance();
    }

    private boolean getHammingDistanceCallsMethodThatMayCalculateDistance() {
        return methodsCalledByGetHammingDistance.stream()
                .anyMatch(this::methodMayCalculateHammingDistance);
    }

    private boolean methodMayCalculateHammingDistance(String methodName) {
        return methods.getOrDefault(methodName, List.of()).stream()
                .anyMatch(this::methodMayCalculateHammingDistance);
    }

    private boolean methodMayCalculateHammingDistance(MethodDeclaration method) {
        return method.getBody()
                .map(this::methodBodyMayCalculateHammingDistance)
                .orElse(false);
    }

    private boolean methodBodyMayCalculateHammingDistance(BlockStmt body) {
        return body.getStatements().stream()
                .anyMatch(this::statementMayCalculateHammingDistance);
    }

    private boolean statementMayCalculateHammingDistance(Statement statement) {
        return hasLoopStatement(statement) || hasLambdaExpression(statement);
    }

    private boolean hasLoopStatement(Statement statement) {
        return !statement.findAll(ForStmt.class).isEmpty()
                || !statement.findAll(ForEachStmt.class).isEmpty()
                || !statement.findAll(WhileStmt.class).isEmpty();
    }

    private boolean hasLambdaExpression(Statement statement) {
        return !statement.findAll(LambdaExpr.class).isEmpty();
    }

    public Set<String> getLongConstructors() {
        return constructors.stream()
                .filter(this::isLongNode)
                .map(ConstructorDeclaration::getNameAsString)
                .collect(Collectors.toUnmodifiableSet());
    }

    public Set<String> getLongMethods() {
        return methods.values().stream()
                .flatMap(Collection::stream)
                .filter(this::isLongNode)
                .map(MethodDeclaration::getNameAsString)
                .collect(Collectors.toUnmodifiableSet());
    }

    private boolean isLongNode(NodeWithRange<?> node) {
        return node.getRange().map(Range::getLineCount).orElse(0) > 20;
    }

    public boolean usesCharacterLiterals() {
        return !hammingClass.findAll(CharLiteralExpr.class).isEmpty();
    }

    public boolean usesStringCharAtOrCodePointAt() {
        return usesMethod("charAt") || usesMethod("codePointAt");
    }

    public boolean shouldUseStreamFilterAndCount() {
        return usesMethod("reduce");
    }

    private boolean usesMethod(String methodName) {
        return methodsCalledByConstructor.contains(methodName)
                || methodsCalledByGetHammingDistance.contains(methodName);
    }
}