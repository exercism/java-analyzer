package analyzer.comments;

import analyzer.Comment;

/**
 * This comment instructs students not to use print statements in order to debug their solution.
 * Instead they should use proper debugging tools.
 *
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/general/avoid_print_statements.md">Markdown Template</a>
 */
public class AvoidPrintStatements extends Comment {
    @Override
    public String getKey() {
        return "java.general.avoid_print_statements";
    }
}
