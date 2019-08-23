package analyzer.exercises;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseProblemException;
import com.github.javaparser.ast.CompilationUnit;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public abstract class Exercise {
    CompilationUnit cu;
    private final JSONObject statusObject;
    private final JSONArray comments;
    private final String directory;

    Exercise(String directory, String solutionFile) {
        this.directory = directory;

        this.statusObject = new JSONObject();
        this.comments = new JSONArray();

        this.statusObject.put("comments", this.comments);

        try {
            this.cu = JavaParser.parse(new File(directory + "src/main/java/" + solutionFile));
        } catch (ParseProblemException e) {
            this.statusObject.put("status", "disapprove_with_comment");
            this.comments.put("java.general.failed_parse");
        } catch (FileNotFoundException e) {
            this.statusObject.put("status", "refer_to_mentor");
            this.comments.put(new JSONObject()
                .put("comment", "java.general.file_not_found")
                .put("params", new JSONObject().put("solutionFile", solutionFile)));
        }
    }

    abstract public void parse();

    protected setStatus(Status status) {
        statusObject.put(STATUS, status.getStatusString());
    }

    public JSONObject getAnalysis() {
        return statusObject;
    }

    public void writeAnalysisToFile() {
        try {
            FileWriter fileWriter = new FileWriter(directory + "/analysis.json");
            fileWriter.write(statusObject.toString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
