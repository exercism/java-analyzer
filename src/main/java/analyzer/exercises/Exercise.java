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
    private static final FileWriter NO_FILE_WRITER = null;

    private CompilationUnit compilationUnit;

    private final JSONObject analysis = new JSONObject();
    private final JSONObject tags = new JSONObject();
    private final FileWriter analysisFileWriter;
    private final FileWriter tagsFileWriter;

    public enum WriteAnalysisToFile {YES, NO}

    protected Exercise(String directory,
                       String solutionFile,
                       String outputDirectory,
                       WriteAnalysisToFile writeAnalysisToFile) {
        this(getSolutionFile(directory, solutionFile),
                getAnalysisFileWriter(outputDirectory, writeAnalysisToFile),
                getTagsFileWriter(directory, writeAnalysisToFile));
    }

    protected Exercise(File solutionFile) {
        this(solutionFile, NO_FILE_WRITER, NO_FILE_WRITER);
    }

    private Exercise(File solutionFile, FileWriter analysisFileWriter, FileWriter tagsFileWriter) {
        this.analysisFileWriter = analysisFileWriter;
        this.tagsFileWriter = tagsFileWriter;

        try {
            this.compilationUnit = new JavaParser().parse(solutionFile).getResult().get();
        } catch (ParseProblemException e) {
            addComment(GeneralComment.FAILED_PARSE);
        } catch (FileNotFoundException e) {
            addComment(
                GeneralComment.FILE_NOT_FOUND,
                Params.newBuilder().addParam("solutionFile", solutionFile.getName()).build());
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
                getAnalysisFileWriter(directory, writeAnalysisToFile),
                getTagsFileWriter(directory, writeAnalysisToFile));
    }

    private static File getSolutionFile(String directory, String solutionFile) {
        return new File(directory + "src/main/java/" + solutionFile);
    }

    private static FileWriter getAnalysisFileWriter(String directory, WriteAnalysisToFile writeAnalysisToFile) {
        return getFileWriter(directory, writeAnalysisToFile, "analysis.json");
    }

    private static FileWriter getTagsFileWriter(String directory, WriteAnalysisToFile writeAnalysisToFile) {
        return getFileWriter(directory, writeAnalysisToFile, "tags.json");
    }

    private static FileWriter getFileWriter(
        String directory, WriteAnalysisToFile writeAnalysisToFile, String filename) {
        if (writeAnalysisToFile == WriteAnalysisToFile.NO) {
            return null;
        }
        try {
            return new FileWriter(directory + filename);
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
        if (analysisFileWriter == null) {
            return;
        }

        try {
            analysisFileWriter.write(analysis.toString());
            analysisFileWriter.flush();
            tagsFileWriter.write(tags.toString());
            tagsFileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
