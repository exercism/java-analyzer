package analyzer;

import org.json.JSONObject;

/**
 * Serializer to create JSON output according to the analyzer interface.
 * @see <a href="https://exercism.org/docs/building/tooling/analyzers/interface">The analyzer interface in the Exercism documentation</a>
 */
public class JsonSerializer {
    /**
     * Serialize a single analyzer comment into its JSON representation.
     * @see <a href="https://exercism.org/docs/building/tooling/analyzers/interface#h-comments">The JSON schema for analyzer comments in the Exercism documentation</a>
     * @param comment An analyzer comment.
     * @return The JSON representation of the analyzer comment.
     */
    public static JSONObject serialize(Comment comment) {
        var object = new JSONObject();
        object.put("comment", comment.getKey());

        if (comment.getType() != null) {
            object.put("type", comment.getType().name().toLowerCase());
        }

        if (comment.getParameters().isEmpty()) {
            return object;
        }

        var paramsObject = new JSONObject();
        comment.getParameters().forEach(paramsObject::put);
        object.put("params", paramsObject);
        return object;
    }

    /**
     * Serialize the analysis result into its JSON representation.
     * @see <a href="https://exercism.org/docs/building/tooling/analyzers/interface#h-analysis-json">The JSON schema for analyzer output in the Exercism documentation</a>
     * @param analysis The analysis result.
     * @return The JSON representation of the analysis result.
     */
    public static JSONObject serialize(Analysis analysis) {
        var object = new JSONObject();

        object.put("summary", analysis.summary());
        analysis.comments().forEach(c -> object.append("comments", serialize(c)));

        return object;
    }

    /**
     * Serialize collected analyzer tags into their JSON representation.
     * @see <a href="https://exercism.org/docs/building/tooling/analyzers/interface#h-tags-json">The JSON schema for analyzer tags in the Exercism documentation</a>
     * @param tags Tags collected by the analyzer.
     * @return The JSON representation of the collected tags.
     */
    public static JSONObject serialize(Tags tags) {
        var json = new JSONObject();
        tags.tags().forEach(t -> json.append("tags", t));
        return json;
    }
}
