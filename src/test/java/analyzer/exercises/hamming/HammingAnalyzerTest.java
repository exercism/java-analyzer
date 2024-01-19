package analyzer.exercises.hamming;

import analyzer.Analyzer;
import analyzer.Comment;
import analyzer.ExerciseAnalyzerTest;
import analyzer.comments.ConstructorTooLong;
import analyzer.comments.MethodTooLong;
import analyzer.comments.UseProperClassName;
import analyzer.comments.UseProperMethodName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class HammingAnalyzerTest extends ExerciseAnalyzerTest {
    @Override
    protected Analyzer getAnalyzer() {
        return new HammingAnalyzer();
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("NoHammingClass.java.txt", new Comment[]{new UseProperClassName("Hamming")}),
                Arguments.of("NoGetHammingDistanceMethod.java.txt", new Comment[]{new UseProperMethodName("getHammingDistance")}),
                Arguments.of("NoConstructor.java.txt", new Comment[]{new MustUseConstructor()}),
                Arguments.of("NoConditionalInConstructor.java.txt", new Comment[]{new MustUseConditionalLogicInConstructor()}),
                Arguments.of("DoesNotThrowInConstructor.java.txt", new Comment[]{new MustThrowInConstructor()}),
                Arguments.of("NoCalculationOfHammingDistance.java.txt", new Comment[]{new MustCalculateHammingDistance()}),
                Arguments.of("UsesCharacterLiterals.java.txt", new Comment[]{new AvoidCharacterLiterals()}),
                Arguments.of("MustUseCharAtOrCodePointAt.java.txt", new Comment[]{new MustUseStringCharAtOrCodePointAt()}),
                Arguments.of("NestedValidation.java.txt", new Comment[]{new CalculateDistanceInConstructor()}),
                Arguments.of("NestedCalculation.java.txt", new Comment[0]),
                Arguments.of("ShouldUseStringIsEmpty.java.txt", new Comment[]{new ShouldUseStringIsEmpty()}),
                Arguments.of("OptimalWithCalculationInGetHammingDistance.java.txt", new Comment[]{new CalculateDistanceInConstructor()}),
                Arguments.of("OptimalWithCalculationDelegatedFromGetHammingDistance.java.txt", new Comment[]{new CalculateDistanceInConstructor()}),
                Arguments.of("ConstructorTooLong.java.txt", new Comment[]{new ConstructorTooLong("Hamming")}),
                Arguments.of("MethodTooLong.java.txt", new Comment[]{new MethodTooLong("calculateHammingDistance")}),
                Arguments.of("UsesStreamReduce.java.txt", new Comment[]{new ShouldUseStreamFilterAndCount()}),
                Arguments.of("OptimalWithCalculationDelegatedFromConstructor.java.txt", new Comment[0]),
                Arguments.of("OptimalWithValidationMethod.java.txt", new Comment[0]));
    }

    @MethodSource("testCases")
    @ParameterizedTest(name = "{0}")
    public void testCommentsOnSolution(String solutionFile, Comment... expectedComments) {
        var actual = analyzeResourceFile(getResourceFileName(solutionFile));

        assertThat(actual.getComments()).containsExactly(expectedComments);
    }

    private static String getResourceFileName(String testFileName) {
        return "/analyzer/exercises/hamming/" + testFileName;
    }
}
