package analyzer.solutions;

import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import static com.github.javaparser.JavaParser.*;
import java.io.File;
import com.github.javaparser.JavaParser;
import java.util.List;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.visitor.TreeVisitor;
import java.util.ArrayList;


public class OptimalFormat {

    public static CompilationUnit getContent(String flname) throws Exception{
        return JavaParser.parse(new File(flname));
    }


    // visits the method call expressions and adds them to a List
    private static class OptionalMethodVisitor extends VoidVisitorAdapter<List<MethodCallExpr>> {
        @Override
        public void visit(MethodCallExpr n, List<MethodCallExpr> arg) {
            arg.add(n);
            super.visit(n, arg);
        }
    }

    // Checks the return for the correct statement (optimal solution 1)
    public static boolean checkReturn(List<ReturnStmt> returns){
        if(returns.size() > 1){
            System.out.println("Can be refactored to use less return statements");
            return false;
        }
        else{
            ReturnStmt n = returns.get(0);
            List<MethodCallExpr> returnMethods = new ArrayList<MethodCallExpr>();
            n.accept(new OptionalMethodVisitor(), returnMethods);
            if(returnMethods.size() == 1){
                if(returnMethods.get(0).getScope().get().toString().equals("String") &&
                        returnMethods.get(0).getNameAsString().equals("format")){
                    if(!returnMethods.get(0).getArgument(0).toString().equals("\"One for %s, one for me.\"")){
                        return false;
                    };
                    if(!returnMethods.get(0).getArgument(1).toString().equals("name == null ? \"you\" : name") &&
                        !returnMethods.get(0).getArgument(1).toString().equals("name != null ? name : \"you\"")) {
                        return false;
                    }
                }
            }
            else {
                return false;
            }
            return true;
        }
    }

}
