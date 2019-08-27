package analyzer.exercises.hamming;

import com.github.javaparser.Range;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.CharLiteralExpr;
import com.github.javaparser.ast.expr.LambdaExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithRange;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ForEachStmt;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.stmt.ThrowStmt;
import com.github.javaparser.ast.stmt.WhileStmt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps;

import static com.google.common.collect.MoreCollectors.toOptional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

class HammingWalker implements Consumer<ClassOrInterfaceDeclaration> {
    private ClassOrInterfaceDeclaration hammingClass;
    private List<ConstructorDeclaration> constructors = ImmutableList.of();
    private ConstructorDeclaration constructor;
    private ListMultimap<String, MethodDeclaration> methods = ImmutableListMultimap.of();
    private Set<String> methodsCalledByConstructor = new HashSet<>();
    private boolean constructorHasIfStatements;
    private boolean constructorThrowsIllegalArgumentDirectly;
    private boolean constructorMayCalculateDistanceDirectly;
    private MethodDeclaration getHammingDistanceMethod;
    private Set<String> methodsCalledByGetHammingDistance = new HashSet<>();
    private boolean getHammingDistanceMayCalculateDistanceDirectly;

    @Override
    public void accept(ClassOrInterfaceDeclaration node) {
        if (node.getNameAsString().equals("Hamming")) {
            hammingClass = node;
            walkHammingClass();
        }
    }

    private void walkHammingClass() {
        methods = getMethodsByName();
        constructors = hammingClass.getConstructors();

        findConstructor().ifPresent(this::walkConstructor);

        findGetHammingDistanceMethod().ifPresent(this::walkGetHammingDistanceMethod);

    }

    private ListMultimap<String, MethodDeclaration> getMethodsByName() {
        return Multimaps.index(
            hammingClass.findAll(MethodDeclaration.class),
            MethodDeclaration::getNameAsString);
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
            .collect(toOptional());
    }

    private void walkGetHammingDistanceMethod(MethodDeclaration getHammingDistanceMethod) {
        this.getHammingDistanceMethod = getHammingDistanceMethod;

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
        return methods.get(methodName).stream()
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

    public boolean hasHammingClass() {
        return hammingClass != null;
    }

    public boolean hasGetHammingDistanceMethod() {
        return getHammingDistanceMethod != null;
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
        return methods.get(methodName).stream()
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
        return methods.get(methodName).stream()
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

    public boolean hasLongConstructor() {
        return constructors.stream().anyMatch(this::isLongNode);
    }

    public boolean hasLongMethod() {
        return methods.values().stream().anyMatch(this::isLongNode);
    }

    private boolean isLongNode(NodeWithRange<?> node) {
        return node.getRange().map(Range::getLineCount).orElse(0) > 20;
    }

    public boolean usesCharacterLiterals() {
        return !hammingClass.findAll(CharLiteralExpr.class).isEmpty();
    }

    public boolean usesStringIsEmpty() {
        return usesMethod("isEmpty");
    }

    public boolean usesStringCharAtOrCodePointAt() {
        return usesMethod("charAt") || usesMethod("codePointAt");
    }

    private boolean usesMethod(String methodName) {
        return methodsCalledByConstructor.contains(methodName)
        || methodsCalledByGetHammingDistance.contains(methodName);
    }
}