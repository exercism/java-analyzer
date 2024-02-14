package analyzer;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class SubmittedSolutionTest {
    @Test
    @DisplayName("Parses all files in the main source folder of the input directory")
    void testParsesFiles() throws IOException {
        var path = Path.of("src/test/resources/solutions/three-solution-files");
        var solution = new SubmittedSolution("three-solution-files", path);

        assertThat(solution.getCompilationUnits())
                .hasSize(3)
                .allSatisfy(compilationUnit ->
                        assertThat(compilationUnit.findFirst(ClassOrInterfaceDeclaration.class).get().getNameAsString())
                                .isIn("Class1", "Class2", "Class3"));
    }
}
