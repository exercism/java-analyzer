package analyzer;

import analyzer.comments.FailedParse;
import analyzer.comments.FileNotFound;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseProblemException;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public abstract class Exercise {
    private CompilationUnit compilationUnit;

    private String summary;
    private final Set<Comment> comments = new HashSet<>();
    private final Set<String> tags = new HashSet<>();

    protected Exercise(String directory, String solutionFile) {
        this(getSolutionFile(directory, solutionFile));
    }

    protected Exercise(File solutionFile) {
        try {
            this.compilationUnit = new JavaParser().parse(solutionFile).getResult().get();
        } catch (ParseProblemException e) {
            addComment(new FailedParse());
        } catch (FileNotFoundException e) {
            addComment(new FileNotFound(solutionFile.getName()));
        }
    }

    private static File getSolutionFile(String directory, String solutionFile) {
        return new File(directory + "src/main/java/" + solutionFile);
    }

    public final void parse() {
        if (compilationUnit == null) {
            return;
        }
        parse(compilationUnit);
    }

    abstract public void parse(CompilationUnit compilationUnit);

    protected void addComment(Comment comment) {
        this.comments.add(comment);
    }

    protected void setSummary(String summary) {
        this.summary = summary;
    }

    protected void addTag(String tag) {
        this.tags.add(tag);
    }

    public Analysis getAnalysis() {
        return new Analysis(this.comments, this.summary);
    }

    public Tags getTags() {
        return new Tags(this.tags);
    }
}
