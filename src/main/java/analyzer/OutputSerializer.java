package analyzer;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.TreeMap;

class OutputSerializer {
    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(Comment.class, new CommentJsonSerializer())
            .setPrettyPrinting()
            .create();

    static String serialize(Output output) {
        return GSON.toJson(output);
    }

    static String serialize(Output.Analysis analysis) {
        return GSON.toJson(analysis);
    }

    static String serialize(Output.Tags tags) {
        return GSON.toJson(tags);
    }

    private static class CommentJsonSerializer implements JsonSerializer<Comment> {
        @Override
        public JsonElement serialize(Comment comment, Type type, JsonSerializationContext jsonSerializationContext) {
            var json = new JsonObject();
            json.addProperty("comment", comment.getKey());
            json.add("params", serializeParameters(comment.getParameters()));

            if (comment.getType() != null) {
                json.addProperty("type", comment.getType().name().toLowerCase());
            }

            return json;
        }

        private static JsonElement serializeParameters(Map<String, String> parameters) {
            var json = new JsonObject();
            new TreeMap<>(parameters).forEach(json::addProperty);
            return json;
        }
    }
}