package analyzer.comments;

import analyzer.Comment;
import analyzer.CommentType;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/general/avoid_hard_coded_test_cases.md">Markdown Template</a>
 */
public class AvoidHardCodedTestCases extends Comment {
    @Override
    public String getKey() {
        return "java.general.avoid_hard_coded_test_cases";
    }

    @Override
    public CommentType getType() {
        return CommentType.ESSENTIAL;
    }
}
