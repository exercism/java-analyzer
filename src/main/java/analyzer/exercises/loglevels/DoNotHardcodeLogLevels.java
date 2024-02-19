package analyzer.exercises.loglevels;

import analyzer.Comment;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/log-levels/do_not_hardcode_log_levels.md">Markdown Template</a>
 */
class DoNotHardcodeLogLevels extends Comment{

    @Override
    public String getKey() {
        return "java.log-levels.do_not_hardcode_log_levels";
    }
    
    @Override
    public Type getType() {
        return Type.ESSENTIAL;
    }
}
