package analyzer.exercises.hamming;

import analyzer.Comment;
import analyzer.CommentType;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/hamming/avoid_character_literals.md">Markdown Template</a>
 */
class AvoidCharacterLiterals extends Comment {
    @Override
    public String getKey() {
        return "java.hamming.avoid_character_literals";
    }

    @Override
    public CommentType getType() {
        return CommentType.ACTIONABLE;
    }
}
