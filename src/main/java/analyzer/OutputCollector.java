package analyzer;

import java.util.List;

/**
 * This class is used to collect analyzer output in the form of comments, tags and an optional summary.
 *
 * @see <a href="https://exercism.org/docs/building/tooling/analyzers/interface">The analyzer interface in the Exercism documentation</a>
 */
public interface OutputCollector {

    /**
     * The summary is a short description of the complete analysis result.
     * It is {@code null} by default.
     *
     * @return The summary if set, {@code null} otherwise.
     */
    String getSummary();

    /**
     * Set the summary of the analysis.
     * If the summary was set previously, setting it again will overwrite it.
     * The summary can be cleared by setting it to {@code null}.
     *
     * @param summary The summary to set.
     */
    void setSummary(String summary);

    /**
     * Retrieve a copy of the comments added to this analysis.
     * The resulting list is guaranteed to contain no duplicates.
     *
     * @return List of comments.
     */
    List<Comment> getComments();

    /**
     * Retrieve a copy of the tags added to this analysis.
     * The resulting list is guaranteed to contain no duplicates.
     *
     * @return List of tags.
     */
    List<String> getTags();

    /**
     * Add a new comment to the analysis.
     * This does nothing if a comment with the same values was added previously.
     *
     * @param comment The comment to add.
     */
    void addComment(Comment comment);

    /**
     * Add a new tag to the analysis.
     * This does nothing if the same tag was added previously.
     *
     * @param tag The tag to add.
     */
    void addTag(String tag);
}
