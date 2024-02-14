package analyzer.test;

import analyzer.Solution;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.util.List;

/**
 * Helper to create a solution from a string containing Java code.
 */
public final class SolutionFromString implements Solution {
    private final String slug;
    private final CompilationUnit compilationUnit;

    public SolutionFromString(String slug, String code) {
        this.slug = slug;
        this.compilationUnit = StaticJavaParser.parse(code);
    }

    @Override
    public String getSlug() {
        return this.slug;
    }

    @Override
    public List<CompilationUnit> getCompilationUnits() {
        return List.of(this.compilationUnit);
    }
}
