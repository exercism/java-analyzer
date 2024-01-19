package analyzer.exercises.hamming;

import analyzer.Comment;
import analyzer.CommentType;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/hamming/must_calculate_hamming_distance.md">Markdown Template</a>
 */
class MustCalculateHammingDistance extends Comment {
    @Override
    public String getKey() {
        return "java.hamming.must_calculate_hamming_distance";
    }

    @Override
    public CommentType getType() {
        return CommentType.ACTIONABLE;
    }
}
