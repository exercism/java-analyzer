package analyzer;

import java.util.Map;
import java.util.Optional;

public class FakeComment extends Comment {
    private String key;
    private Map<String, String> parameters;
    private Type type;

    public FakeComment() {
        this(null, null, null);
    }

    public FakeComment(String key, Map<String, String> parameters, Type type) {
        this.key = key;
        this.parameters = parameters;
        this.type = type;
    }

    @Override
    public String getKey() {
        return Optional.ofNullable(this.key).orElse("java.test.fake");
    }

    public FakeComment withKey(String key) {
        this.key = key;
        return this;
    }

    @Override
    public Map<String, String> getParameters() {
        return Optional.ofNullable(this.parameters).orElse(super.getParameters());
    }

    public FakeComment withParameters(Map<String, String> parameters) {
        this.parameters = parameters;
        return this;
    }

    @Override
    public Type getType() {
        return Optional.ofNullable(this.type).orElse(super.getType());
    }

    public FakeComment withType(Type type) {
        this.type = type;
        return this;
    }
}
