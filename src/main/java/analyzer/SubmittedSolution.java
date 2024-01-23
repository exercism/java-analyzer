package analyzer;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.utils.SourceRoot;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class SubmittedSolution implements Solution {
    private static final String SOURCE_ROOT_PATH = "src/main/java";

    private final String slug;
    private final List<CompilationUnit> compilationUnits;

    SubmittedSolution(String slug, Path inputDirectory) throws IOException {
        this.slug = slug;
        this.compilationUnits = new ArrayList<>();

        var sourceRoot = new SourceRoot(inputDirectory.resolve(SOURCE_ROOT_PATH));
        for (var result : sourceRoot.tryToParse()) {
            this.compilationUnits.add(result.getResult().get());
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
