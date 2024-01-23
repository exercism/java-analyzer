package analyzer.comments;

import analyzer.Comment;

/**
 * This comment requests students to leave feedback on the analyzer comments.
 * Use it whenever new comments or analyzers are implemented, as a way to "beta-test" the new functionality.
 *
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/general/feedback_request.md">Markdown Template</a>
 */
public class FeedbackRequest extends Comment {
    @Override
    public String getKey() {
        return "java.general.feedback_request";
    }
}
