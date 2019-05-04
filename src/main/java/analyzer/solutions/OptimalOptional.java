package analyzer.solutions;

import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


public class OptimalOptional {
    CompilationUnit cu;

    OptimalOptional(CompilationUnit cu){
        this.cu = cu;
    }

    private static class OptionalMethodVisitor extends VoidVisitorAdapter<List<MethodCallExpr>> {
        @Override
        public void visit(MethodCallExpr n, List<MethodCallExpr> arg) {
            // Found a method call
            arg.add(n);
            // Don't forget to call super, it may find more method calls inside the arguments of this method call, for example.
            super.visit(n, arg);
        }
    }

    public static boolean checkReturn(List<ReturnStmt> returns){
        if(returns.size() > 1){
            //when would this apply?
            System.out.println("Can be refactored to use less return statements");
            return false;
        }
        else{
            ReturnStmt n = returns.get(0);
            List<MethodCallExpr> returnMethods = new ArrayList<MethodCallExpr>();
            n.accept(new OptionalMethodVisitor(), returnMethods);
            if(returnMethods.size() == 3){
                if(returnMethods.get(0).getScope().get().toString().equals("String") &&
                        returnMethods.get(0).getNameAsString().equals("format")){
                    if(!returnMethods.get(0).getArgument(0).toString().equals("\"One for %s, one for me.\"")){
                        return false;
                    };
                }
                if(returnMethods.get(1).getScope().get().toString().equals("Optional.ofNullable(name)") &&
                        returnMethods.get(1).getNameAsString().equals("orElse")){
                    if(!returnMethods.get(1).getArgument(0).toString().equals("\"you\"")){
                        return false;
                    };
                }
                if(returnMethods.get(2).getScope().get().toString().equals("Optional") &&
                        returnMethods.get(2).getNameAsString().equals("orNullable")){
                    if(!returnMethods.get(2).getArgument(0).toString().equals("name")){
                        return false;
                    };
                }
            }
            return true;
        }
    }

}
