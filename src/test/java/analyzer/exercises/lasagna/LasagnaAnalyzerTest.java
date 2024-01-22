package analyzer.exercises.lasagna;

import analyzer.AnalyzerTest;
import analyzer.Comment;
import analyzer.comments.ExemplarSolution;
import analyzer.comments.RemoveTodoComments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LasagnaAnalyzerTest extends AnalyzerTest<LasagnaAnalyzer> {
    public LasagnaAnalyzerTest() {
        super(LasagnaAnalyzer.class);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("ExemplarSolution.java", List.of(new ExemplarSolution("Lasagna"))),
                Arguments.of("ExemplarSolutionWithTodoComments.java", List.of(new RemoveTodoComments())),
                Arguments.of("NoReuseOfExpectedMinutesInOven.java",
                        List.of(new ReuseCode("remainingMinutesInOven", "expectedMinutesInOven"))),
                Arguments.of("NoReuseOfPreparationTimeInMinutes.java",
                        List.of(new ReuseCode("totalTimeInMinutes", "preparationTimeInMinutes"))),
                Arguments.of("NoReuseOfBothMethods.java",
                        List.of(
                                new ReuseCode("remainingMinutesInOven", "expectedMinutesInOven"),
                                new ReuseCode("totalTimeInMinutes", "preparationTimeInMinutes")
                        )
                )
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("testCases")
    public void testCommentsOnSolution(String filename, List<Comment> expectedComments) {
        var analysis = analyzeResourceFile("/analyzer/exercises/lasagna/" + filename);
        assertThat(analysis.getComments()).containsExactlyInAnyOrder(expectedComments.toArray(Comment[]::new));
    }
}
