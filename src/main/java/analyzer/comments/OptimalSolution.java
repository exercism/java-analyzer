package analyzer.comments;

import analyzer.Comment;
import analyzer.CommentType;

import java.util.Map;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/general/optimal_solution.md">Markdown Template</a>
 */
public class OptimalSolution extends Comment {
    private final String exerciseName;

    public OptimalSolution(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    @Override
    public String getKey() {
        return "java.general.optimal_solution";
    }

    @Override
    public Map<String, String> getParameters() {
        return Map.of("exerciseName", this.exerciseName);
    }

    @Override
    public CommentType getType() {
        return CommentType.CELEBRATORY;
    }
}
