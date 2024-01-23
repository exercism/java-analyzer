package analyzer.exercises.leap;

import analyzer.AnalyzerTest;
import analyzer.Comment;
import analyzer.comments.AvoidHardCodedTestCases;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LeapAnalyzerTest extends AnalyzerTest<LeapAnalyzer> {
    private static final String RESOURCE_LOCATION = "/analyzer/exercises/leap/";

    public LeapAnalyzerTest() {
        super(LeapAnalyzer.class);
    }

    @Test
    public void optimalSolution() {
        var analysis = analyzeResourceFile(RESOURCE_LOCATION + "OptimalSolution.java");
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
        var analysis = analyzeResourceFile(RESOURCE_LOCATION + filename);
        assertThat(analysis.getComments()).contains(expectedComment);
    }
}
