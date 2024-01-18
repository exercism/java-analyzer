package analyzer;

import org.json.JSONObject;

public class JsonSerializer {
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

    public static JSONObject serialize(Analysis analysis) {
        var object = new JSONObject();

        object.put("summary", analysis.summary());
        analysis.comments().forEach(c -> object.append("comments", serialize(c)));

        return object;
    }

    public static JSONObject serialize(Tags tags) {
        var json = new JSONObject();
        tags.tags().forEach(t -> json.append("tags", t));
        return json;
    }
}
