package analyzer;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.util.List;

public class SolutionFromString implements Solution {
    private final String slug;
    private final CompilationUnit compilationUnit;

    public SolutionFromString(String slug, String code) {
        this.slug = slug;
        this.compilationUnit = StaticJavaParser.parse(code);
    }

    public SolutionFromString(String code) {
        this(null, code);
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
