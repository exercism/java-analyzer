package analyzer.exercises.loglevels;

import analyzer.Comment;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/log-levels/avoid_using_string_format.md">Markdown Template</a>
 */
class PreferStringConcatenation extends Comment {

    @Override
    public String getKey() {
        return "java.log-levels.prefer_string_concatenation";
    }
    
    @Override
    public Type getType() {
        return Type.INFORMATIVE;
    }
}