package analyzer;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.util.ArrayList;
import java.util.List;

public class SolutionFromResourceFiles implements Solution {
    private final String slug;
    private final List<CompilationUnit> compilationUnits;

    public SolutionFromResourceFiles(String slug, String resourceFileName, String... moreResourceFileNames) {
        this.slug = slug;
        this.compilationUnits = new ArrayList<>();

        compilationUnits.add(parseResourceFile(resourceFileName));
        for (String fileName : moreResourceFileNames) {
            compilationUnits.add(parseResourceFile(fileName));
        }
    }

    private static CompilationUnit parseResourceFile(String fileName) {
        var inputStream = SolutionFromResourceFiles.class.getResourceAsStream(fileName);
        return StaticJavaParser.parse(inputStream);
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
