package analyzer.exercises.twofer;

import analyzer.AnalyzerRoot;
import analyzer.SolutionFromResourceFiles;
import org.approvaltests.Approvals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static analyzer.TestOutputSerializer.printable;

public class TwoferAnalyzerTest {

    private static Stream<String> scenarios() {
        return Stream.of(
                "UsesLambda",
                "UsesLoop",
                "HardCodedTestCases",
                "NoConditionalLogic",
                "UsesStringFormat",
                "UsesMultipleReturns",
                "OptimalNoTernary",
                "Optimal"
        );
    }

    @MethodSource("scenarios")
    @ParameterizedTest(name = "{0}")
    public void analysis(String scenario) {
        var resourceFileName = "/scenarios/twofer/" + scenario + ".java";
        var solution = new SolutionFromResourceFiles("two-fer", resourceFileName);
        var output = AnalyzerRoot.analyze(solution);

        Approvals.verify(printable(output.analysis()), Approvals.NAMES.withParameters(scenario));
    }
}
