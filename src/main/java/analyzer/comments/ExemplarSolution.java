package analyzer.comments;

import analyzer.Comment;

import java.util.Map;

/**
 * Use this comment if the solution is comparable to the exemplar solution.
 * This comment is generally used for concept exercises.
 *
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/general/exemplar.md">Markdown Template</a>
 */
public class ExemplarSolution extends Comment {
    private final String exerciseName;

    public ExemplarSolution(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    @Override
    public String getKey() {
        return "java.general.exemplar";
    }

    @Override
    public Map<String, String> getParameters() {
        return Map.of("exerciseName", this.exerciseName);
    }

    @Override
    public Type getType() {
        return Type.CELEBRATORY;
    }
}
