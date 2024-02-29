package analyzer.comments;

import analyzer.Comment;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/general/prefer_string_concatenation.md">Markdown Template</a>
 */
public class PreferStringConcatenation extends Comment {

    @Override
    public String getKey() {
        return "java.general.prefer_string_concatenation";
    }
    
    @Override
    public Type getType() {
        return Type.INFORMATIVE;
    }
}
