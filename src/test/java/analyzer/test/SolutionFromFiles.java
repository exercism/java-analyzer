package analyzer.test;

import analyzer.Solution;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Helper to create a solution from one or more files.
 */
public final class SolutionFromFiles implements Solution {
    private final String slug;
    private final List<CompilationUnit> compilationUnits;

    public SolutionFromFiles(String slug, Path... files) throws IOException {
        this.slug = slug;
        this.compilationUnits = new ArrayList<>();

        for (var file : files) {
            compilationUnits.add(StaticJavaParser.parse(file));
        }
    }

    @Override
    public String getSlug() {
        return this.slug;
    }

    @Override
    public List<CompilationUnit> getCompilationUnits() {
        return List.copyOf(this.compilationUnits);
    }
}
