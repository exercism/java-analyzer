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
    private static final String COMMENTS = "comments";
    private static final String COMMENT = "comment";
    private static final String PARAMS = "params";
    private static final String TYPE = "type";
    private Type type;
    private static final FileWriter NO_FILE_WRITER = null;

    private CompilationUnit compilationUnit;

    private final JSONObject analysis = new JSONObject();
    private final FileWriter fileWriter;

    public enum WriteAnalysisToFile {YES, NO}

    protected Exercise(String directory,
                       String solutionFile,
                       String outputDirectory,
                       WriteAnalysisToFile writeAnalysisToFile) {
        this(getSolutionFile(directory, solutionFile),
                getFileWriter(outputDirectory, writeAnalysisToFile));
    }

    protected Exercise(File solutionFile) {
        this(solutionFile, NO_FILE_WRITER);
    }

    private Exercise(File solutionFile, FileWriter fileWriter) {
        this.fileWriter = fileWriter;

        try {
            this.compilationUnit = JavaParser.parse(solutionFile);
        } catch (ParseProblemException e) {
            addComment(GeneralComment.FAILED_PARSE);
        } catch (FileNotFoundException e) {
            addComment(
                GeneralComment.FILE_NOT_FOUND,
                Params.newBuilder().addParam("solutionFile", solutionFile.getName()).build(),
                    Type.DEFAULT);
        }
    }

    /**
     * @deprecated The output file should no longer be written in the input file directory
     */
    @Deprecated
    protected Exercise(String directory, String solutionFile) {
        this(directory, solutionFile, WriteAnalysisToFile.YES);
    }

    /**
     * @deprecated The output file should no longer be written in the input file directory
     */
    @Deprecated
    protected Exercise(String directory,
                       String solutionFile,
                       WriteAnalysisToFile writeAnalysisToFile) {
        this(getSolutionFile(directory, solutionFile),
                getFileWriter(directory, writeAnalysisToFile));
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

    protected void addComment(Comment comment) {
        addComment(comment, Params.EMPTY, Type.DEFAULT);
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

    protected void addComment(Comment comment, Params params, String type) {
        if (params.isEmpty()) {
            this.analysis.append(COMMENTS, comment.toJson());
            return;
        }
        this.analysis.append(
                COMMENTS,
                new JSONObject()
                        .put(COMMENT, comment.toJson())
                        .put(PARAMS, params.toJson())
                        .put(TYPE, Type.DEFAULT));
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
