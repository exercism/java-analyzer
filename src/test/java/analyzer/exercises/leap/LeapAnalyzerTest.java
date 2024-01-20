package analyzer.exercises.leap;

import analyzer.Analyzer;
import analyzer.AnalyzerTest;
import analyzer.Comment;
import analyzer.comments.AvoidHardCodedTestCases;
import org.junit.jupiter.api.Test;
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

    @Test
    public void noCommentsOnOptimalSolution() {
        var actual = analyzeResourceFile(getResourceFileName("Optimal.java"));

        assertThat(actual.getComments()).isEmpty();
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("UsesJavaTime.java", new Comment[]{new NoBuiltInMethods()}),
                Arguments.of("UsesGregorianCalendar.java", new Comment[]{new NoBuiltInMethods()}),
                Arguments.of("HardCodedTestCases.java", new Comment[]{new AvoidHardCodedTestCases()}),
                Arguments.of("UsesIfStatements.java", new Comment[]{new AvoidConditionalLogic()}),
                Arguments.of("UsesTernary.java", new Comment[]{new AvoidConditionalLogic()}),
                Arguments.of("TooManyChecks.java", new Comment[]{new UseMinimumNumberOfChecks()})
        );
    }

    @MethodSource("testCases")
    @ParameterizedTest(name = "{0}")
    public void testCommentsOnSolution(String solutionFile, Comment... expectedComments) {
        var actual = analyzeResourceFile(getResourceFileName(solutionFile));

        assertThat(actual.getComments()).contains(expectedComments);
    }

    private static String getResourceFileName(String testFileName) {
        return "/analyzer/exercises/leap/" + testFileName;
    }
}
