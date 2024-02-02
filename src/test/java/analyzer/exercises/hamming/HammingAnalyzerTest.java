package analyzer.exercises.hamming;

import analyzer.AnalyzerRoot;
import analyzer.SolutionFromResourceFiles;
import org.approvaltests.Approvals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static analyzer.TestOutputSerializer.printable;

class HammingAnalyzerTest {

    private static Stream<String> scenarios() {
        return Stream.of(
                "NoConstructor",
                "NoConditionalInConstructor",
                "DoesNotThrowInConstructor",
                "NoCalculationOfHammingDistance",
                "UsesCharacterLiterals",
                "MustUseCharAtOrCodePointAt",
                "NestedValidation",
                "NestedCalculation",
                "OptimalWithCalculationInGetHammingDistance",
                "OptimalWithCalculationDelegatedFromGetHammingDistance",
                "ConstructorTooLong",
                "MethodTooLong",
                "UsesStreamReduce",
                "OptimalWithCalculationDelegatedFromConstructor",
                "OptimalWithValidationMethod"
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("scenarios")
    void analysis(String scenario) {
        var resourceFileName = "/scenarios/hamming/" + scenario + ".java";
        var solution = new SolutionFromResourceFiles("hamming", resourceFileName);
        var output = AnalyzerRoot.analyze(solution);

        Approvals.verify(printable(output.analysis()), Approvals.NAMES.withParameters(scenario));
    }
}
