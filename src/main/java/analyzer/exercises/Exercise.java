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
    JSONObject statusObject;
    JSONArray comments;
    String dir;

    Exercise(String dir, String solutionFile) {

        this.statusObject = new JSONObject();
        this.comments = new JSONArray();
        this.dir = dir;

        this.statusObject.put("comments", this.comments);

        try {
            this.cu = JavaParser.parse(new File(dir + "src/main/java/" + solutionFile));
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

    public JSONObject getAnalysis() {
        return this.statusObject;
    }

    public void writeAnalysisToFile() {
        try {
            FileWriter fileWriter = new FileWriter(this.dir + "/analysis.json");
            fileWriter.write(this.statusObject.toString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
