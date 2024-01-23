package analyzer;

import org.json.JSONObject;

import java.io.IOException;
import java.io.Writer;
import java.util.Optional;

/**
 * The {@link OutputWriter} converts the analysis result into JSON output and writes it to the writers passed to the constructor.
 *
 * @see <a href="https://exercism.org/docs/building/tooling/analyzers/interface">The analyzer interface in the Exercism documentation</a>
 */
public class OutputWriter {
    private static final int JSON_INDENTATION = 2;

    private final Writer analysisWriter;
    private final Writer tagsWriter;

    public OutputWriter(Writer analysisWriter, Writer tagsWriter) {
        this.analysisWriter = analysisWriter;
        this.tagsWriter = tagsWriter;
    }

    public void write(Analysis analysis) throws IOException {
        writeAnalysis(analysis);
        writeTags(analysis);
    }

    private void writeAnalysis(Analysis analysis) throws IOException {
        var json = new JSONObject();

        if (analysis.getSummary() != null) {
            json.put("summary", analysis.getSummary());
        }

        analysis.getComments()
                .stream()
                .sorted(OutputWriter::compareCommentsByType)
                .forEachOrdered(comment -> json.append("comments", serialize(comment)));

        this.analysisWriter.write(json.toString(JSON_INDENTATION));
    }

    private void writeTags(Analysis analysis) throws IOException {
        var json = new JSONObject();
        for (String tag : analysis.getTags()) {
            json.append("tags", tag);
        }

        this.tagsWriter.write(json.toString(JSON_INDENTATION));
    }

    private static JSONObject serialize(Comment comment) {
        var json = new JSONObject();
        json.put("comment", comment.getKey());

        if (comment.getType() != null) {
            json.put("type", comment.getType().name().toLowerCase());
        }

        if (comment.getParameters().isEmpty()) {
            return json;
        }

        var paramsJson = new JSONObject();
        comment.getParameters().forEach(paramsJson::put);
        json.put("params", paramsJson);
        return json;
    }

    private static int compareCommentsByType(Comment a, Comment b) {
        var ordinalA = Optional.ofNullable(a.getType()).map(Comment.Type::ordinal).orElse(Integer.MAX_VALUE);
        var ordinalB = Optional.ofNullable(b.getType()).map(Comment.Type::ordinal).orElse(Integer.MAX_VALUE);
        return Integer.compare(ordinalA, ordinalB);
    }
}
