package analyzer.exercises.leap;

import analyzer.AnalyzerRoot;
import analyzer.SolutionFromResourceFiles;
import org.approvaltests.Approvals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static analyzer.TestOutputSerializer.printable;

class LeapAnalyzerTest {

    private static Stream<String> scenarios() {
        return Stream.of(
                "OptimalSolution",
                "HardCodedTestCases",
                "UsingGregorianCalendar",
                "UsingIfStatements",
                "UsingJavaTime",
                "UsingTernary",
                "UsingTooManyChecks"
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("scenarios")
    void analysis(String scenario) {
        var resourceFileName = "/scenarios/leap/" + scenario + ".java";
        var solution = new SolutionFromResourceFiles("leap", resourceFileName);
        var output = AnalyzerRoot.analyze(solution);

        Approvals.verify(printable(output.analysis()), Approvals.NAMES.withParameters(scenario));
    }
}
