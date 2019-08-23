package analyzer.exercises;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import org.json.JSONObject;

public final class Params {
    public static final Params EMPTY = newBuilder().build();

    private final Map<String, String> params;

    private Params(Map<String, String> params) {
        this.params = params;
    }

    public boolean isEmpty() {
        return params.isEmpty();
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        params.forEach((param, value) -> json.put(param, value));
        return json;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final ImmutableMap.Builder<String, String> params =
            ImmutableMap.builder();

        public Builder addParam(String param, String value) {
            params.put(param, value);
            return this;
        }

        public Params build() {
            return new Params(params.build());
        }
    }
}