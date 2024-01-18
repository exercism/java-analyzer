package analyzer.comments;

import analyzer.Comment;

import java.util.Map;

/**
 * @see <a href="https://github.com/exercism/website-copy/blob/main/analyzer-comments/java/general/file_not_found.md">Markdown Template</a>
 */
public class FileNotFound extends Comment {
    private final String solutionFile;

    public FileNotFound(String solutionFile) {
        this.solutionFile = solutionFile;
    }

    @Override
    public String getKey() {
        return "java.general.file_not_found";
    }

    @Override
    public Map<String, String> getParameters() {
        return Map.of("solutionFile", this.solutionFile);
    }
}
