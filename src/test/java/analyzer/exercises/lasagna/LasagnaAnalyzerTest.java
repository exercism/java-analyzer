package analyzer.exercises.lasagna;

import analyzer.AnalyzerTestHelper;
import analyzer.Comment;
import analyzer.SolutionFromResourceFiles;
import analyzer.comments.ExemplarSolution;
import analyzer.comments.RemoveTodoComments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LasagnaAnalyzerTest {

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
        var solution = new SolutionFromResourceFiles("lasagna", "/analyzer/exercises/lasagna/" + filename);
        var analysis = AnalyzerTestHelper.analyze(solution, LasagnaAnalyzer::new);
        assertThat(analysis.getComments()).containsExactlyInAnyOrder(expectedComments.toArray(Comment[]::new));
    }
}
