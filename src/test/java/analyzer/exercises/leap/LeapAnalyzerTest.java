package analyzer.exercises.leap;

import analyzer.AnalyzerTestHelper;
import analyzer.Comment;
import analyzer.SolutionFromResourceFiles;
import analyzer.comments.AvoidHardCodedTestCases;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LeapAnalyzerTest {

    @Test
    public void optimalSolution() {
        var solution = new SolutionFromResourceFiles("leap", getResourceFileName("OptimalSolution.java"));
        var analysis = AnalyzerTestHelper.analyze(solution, LeapAnalyzer::new);
        assertThat(analysis.getComments()).isEmpty();
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("HardCodedTestCases.java", new AvoidHardCodedTestCases()),
                Arguments.of("UsingGregorianCalendar.java", new NoBuiltInMethods()),
                Arguments.of("UsingIfStatements.java", new AvoidConditionalLogic()),
                Arguments.of("UsingJavaTime.java", new NoBuiltInMethods()),
                Arguments.of("UsingTernary.java", new AvoidConditionalLogic()),
                Arguments.of("UsingTooManyChecks.java", new UseMinimumNumberOfChecks())
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("testCases")
    public void testCommentsOnSolution(String filename, Comment expectedComment) {
        var solution = new SolutionFromResourceFiles("leap", getResourceFileName(filename));
        var analysis = AnalyzerTestHelper.analyze(solution, LeapAnalyzer::new);
        assertThat(analysis.getComments()).contains(expectedComment);
    }

    private static String getResourceFileName(String testFileName) {
        return "/analyzer/exercises/leap/" + testFileName;
    }
}
