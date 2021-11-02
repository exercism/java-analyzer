package analyzer.exercises;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseProblemException;
import com.github.javaparser.ast.CompilationUnit;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;

public abstract class Exercise {
    private static final String COMMENTS = "comments";
    private static final String COMMENT = "comment";
    private static final String PARAMS = "params";

    private CompilationUnit compilationUnit;
    private final JSONObject analysis = new JSONObject();

    protected Exercise(File solutionFile) {
        try {
            this.compilationUnit = JavaParser.parse(solutionFile);
        } catch (ParseProblemException e) {
            addComment(GeneralComment.FAILED_PARSE);
        } catch (FileNotFoundException e) {
            addComment(GeneralComment.FILE_NOT_FOUND,
                    Params.newBuilder()
                            .addParam("solutionFile", solutionFile.getName())
                            .build());
        }
    }

    public final void parse() {
        if (compilationUnit == null) {
            return;
        }
        parse(compilationUnit);
    }

    public abstract void parse(CompilationUnit compilationUnit);

    protected void addComment(Comment comment) {
        addComment(comment, Params.EMPTY);
    }

    protected void addComment(Comment comment, Params params) {
        if (params.isEmpty()) {
            this.analysis.append(COMMENTS, comment.toJson());
            return;
        }
        this.analysis.append(
            COMMENTS,
            new JSONObject()
                .put(COMMENT, comment.toJson())
                .put(PARAMS, params.toJson()));
    }

    public JSONObject getAnalysis() {
        return analysis;
    }
}
