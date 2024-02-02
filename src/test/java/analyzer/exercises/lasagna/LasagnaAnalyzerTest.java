package analyzer.exercises.lasagna;

import analyzer.AnalyzerRoot;
import analyzer.SolutionFromResourceFiles;
import org.approvaltests.Approvals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static analyzer.TestOutputSerializer.printable;

class LasagnaAnalyzerTest {

    private static Stream<String> scenarios() {
        return Stream.of(
                "ExemplarSolution",
                "ExemplarSolutionWithTodoComments",
                "NoReuseOfExpectedMinutesInOven",
                "NoReuseOfPreparationTimeInMinutes",
                "NoReuseOfBothMethods"
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("scenarios")
    void analysis(String scenario) {
        var resourceFileName = "/scenarios/lasagna/" + scenario + ".java";
        var solution = new SolutionFromResourceFiles("lasagna", resourceFileName);
        var output = AnalyzerRoot.analyze(solution);

        Approvals.verify(printable(output.analysis()), Approvals.NAMES.withParameters(scenario));
    }
}
