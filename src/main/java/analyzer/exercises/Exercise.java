package analyzer.exercises;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseProblemException;
import com.github.javaparser.ast.CompilationUnit;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Exercise {
    private static final String STATUS = "status";
    private static final String COMMENTS = "comments";
    private static final String COMMENT = "comment";
    private static final String PARAMS = "params";
    private static final FileWriter NO_FILE_WRITER = null;

    private CompilationUnit compilationUnit;

    private final JSONObject analysis = new JSONObject();
    private final FileWriter fileWriter;

    public static enum WriteAnalysisToFile { YES, NO }

    protected Exercise(String directory, String solutionFile) {
        this(directory, solutionFile, WriteAnalysisToFile.YES);
    }

    protected Exercise(
        String directory,
        String solutionFile,
        WriteAnalysisToFile writeAnalysisToFile) {
        this(
            getSolutionFile(directory, solutionFile),
            getFileWriter(directory, writeAnalysisToFile));
    }

    protected Exercise(File solutionFile) {
        this(solutionFile, NO_FILE_WRITER);
    }

    private Exercise(File solutionFile, FileWriter fileWriter) {
        this.fileWriter = fileWriter;

        try {
            this.compilationUnit = JavaParser.parse(solutionFile);
        } catch (ParseProblemException e) {
            setStatus(Status.DISAPPROVE);
            addComment(GeneralComment.FAILED_PARSE);
        }catch (FileNotFoundException e) {
            setStatus(Status.REFER_TO_MENTOR);
            addComment(
                GeneralComment.FILE_NOT_FOUND,
                Params.newBuilder().addParam("solutionFile", solutionFile.getName()).build());
        }
    }

    private static File getSolutionFile(String directory, String solutionFile) {
        return new File(directory + "src/main/java/" + solutionFile);
    }

    private static FileWriter getFileWriter(
        String directory, WriteAnalysisToFile writeAnalysisToFile) {
        if (writeAnalysisToFile == WriteAnalysisToFile.NO) {
            return null;
        }
        try {
            return new FileWriter(directory + "analysis.json");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void parse() {
        if (compilationUnit == null) {
            return;
        }
        parse(compilationUnit);
    }

    abstract public void parse(CompilationUnit compilationUnit);

    protected void setStatus(Status status) {
        analysis.put(STATUS, status.toJson());
    }

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

    public void writeAnalysisToFile() {
        if (fileWriter == null) {
            return;
        }

        try {
            fileWriter.write(analysis.toString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
