package analyzer.exercises.carsassemble;

import analyzer.Analyzer;
import analyzer.OutputCollector;
import analyzer.Solution;
import analyzer.comments.ExemplarSolution;
import analyzer.comments.MethodTooLong;
import analyzer.comments.ReuseCode;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

/**
 * The {@link CarsAssembleAnalyzer} is the analyzer implementation for the {@code cars-assemble} concept exercise.
 * 
 * @see <a href="https://github.com/exercism/java/tree/main/exercises/concept/cars-assemble">The cars-assemble exercise on the Java track</a>
 */
public class CarsAssembleAnalyzer extends VoidVisitorAdapter<OutputCollector> implements Analyzer {
    private static final String EXERCISE_NAME = "CarsAssemble";
    private static final String MAGIC_NUMBER = "221";
    private static final String PRODUCTION_RATE_PER_HOUR_METHOD = "productionRatePerHour";
    private static final String WORKING_ITEMS_PER_MINUTE_METHOD = "workingItemsPerMinute";
    private static final String RETURN = "return";

    @Override
    public void analyze(Solution solution, OutputCollector output) {

        for (var compilationUnit : solution.getCompilationUnits()) {
            compilationUnit.getClassByName(EXERCISE_NAME).ifPresent(c -> c.accept(this, output));
        }

        if (output.getComments().isEmpty()) {
            output.addComment(new ExemplarSolution(EXERCISE_NAME));
        }
    }

    @Override
    public void visit(MethodDeclaration n, OutputCollector output) {

        if(n.getNameAsString().equals(PRODUCTION_RATE_PER_HOUR_METHOD) && !hasHelperMethod(n)){
            output.addComment(new MethodTooLong(PRODUCTION_RATE_PER_HOUR_METHOD));
        }

        if(n.getNameAsString().equals(WORKING_ITEMS_PER_MINUTE_METHOD) && !reuseMethod(n)){
            output.addComment(new ReuseCode(WORKING_ITEMS_PER_MINUTE_METHOD, PRODUCTION_RATE_PER_HOUR_METHOD));
        }

        if(useMagicNumber(n)){
            output.addComment(new PreferStoringConstantInField());
        }

        super.visit(n, output);

    }

    @Override
    public void visit(IfStmt node, OutputCollector output){

        if(node.getThenStmt().toString().contains(RETURN) && node.hasElseBlock()){
            output.addComment(new AvoidUsingReturnInElseStatement());
        }

        super.visit(node, output);
    }

    private boolean hasHelperMethod(MethodDeclaration n){

        if(n.getBody().isEmpty()){
            return true;
        }

        BlockStmt stmt = n.getBody().get();
        List<Statement> IfStmts = stmt.getStatements().stream().filter(Statement::isIfStmt).toList();
        for(Statement s : IfStmts){
            return ((IfStmt) s).hasElseBlock();
        }
        return true;
    }

    private boolean reuseMethod(MethodDeclaration n){
        return !n.findAll(MethodCallExpr.class).stream().filter(m -> m.getNameAsString().equals(PRODUCTION_RATE_PER_HOUR_METHOD)).toList().isEmpty();
    }

    private boolean useMagicNumber(MethodDeclaration n){

        if(n.getBody().isEmpty()){
            return false;
        }

        BlockStmt stmt = n.getBody().get();
        return stmt.toString().contains(MAGIC_NUMBER);

    }

}

