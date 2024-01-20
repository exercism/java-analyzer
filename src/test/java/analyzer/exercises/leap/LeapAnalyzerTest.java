package analyzer.exercises.leap;

import analyzer.Analyzer;
import analyzer.AnalyzerTest;
import analyzer.Comment;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LeapAnalyzerTest extends AnalyzerTest {
    @Override
    protected Analyzer getAnalyzer() {
        return new LeapAnalyzer();
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("Optimal.java", new Comment[0]),
                Arguments.of("UsesJavaTime.java", new Comment[]{new DoNotUseJavaTime()})
        );
    }

    @MethodSource("testCases")
    @ParameterizedTest(name = "{0}")
    public void testCommentsOnSolution(String solutionFile, Comment... expectedComments) {
        var actual = analyzeResourceFile(getResourceFileName(solutionFile));

        assertThat(actual.getComments()).containsExactly(expectedComments);
    }

    private static String getResourceFileName(String testFileName) {
        return "/analyzer/exercises/leap/" + testFileName;
    }
}
