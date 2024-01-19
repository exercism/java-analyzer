package analyzer.exercises.twofer;

import analyzer.Analyzer;
import analyzer.Comment;
import analyzer.ExerciseAnalyzerTest;
import analyzer.comments.AvoidHardCodedTestCases;
import analyzer.comments.UseProperClassName;
import analyzer.comments.UseProperMethodName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoferAnalyzerTest extends ExerciseAnalyzerTest {

    @Override
    protected Analyzer getAnalyzer() {
        return new TwoferAnalyzer();
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("NoTwoferClass.java.txt", new Comment[]{new UseProperClassName("Twofer")}),
                Arguments.of("NoTwoferMethod.java.txt", new Comment[]{new UseProperMethodName("twofer")}),
                Arguments.of("UsesLambda.java.txt", new Comment[0]),
                Arguments.of("UsesLoop.java.txt", new Comment[0]),
                Arguments.of("HardCodedTestCases.java.txt", new Comment[]{new AvoidHardCodedTestCases()}),
                Arguments.of("NoConditionalLogic.java.txt", new Comment[]{new UseConditionalLogic()}),
                Arguments.of("UsesStringFormat.java.txt", new Comment[]{new AvoidStringFormat()}),
                Arguments.of("UsesMultipleReturns.java.txt", new Comment[]{new UseOneReturn()}),
                Arguments.of("OptimalNoTernary.java.txt", new Comment[]{new UseTernaryOperator()}),
                Arguments.of("Optimal.java.txt", new Comment[0])
        );
    }

    @MethodSource("testCases")
    @ParameterizedTest(name = "{0}")
    public void testCommentsOnSolution(String solutionFile, Comment... expectedComments) {
        var actual = analyzeResourceFile(getResourceFileName(solutionFile));

        assertThat(actual.getComments()).containsExactly(expectedComments);
    }

    private static String getResourceFileName(String testFileName) {
        return "/analyzer/exercises/twofer/" + testFileName;
    }
}
