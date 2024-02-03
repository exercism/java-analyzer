package analyzer;

import analyzer.test.SolutionFromFiles;
import org.approvaltests.Approvals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Path;

import static analyzer.OutputSerializer.serialize;

class AnalyzerIntegrationTest {
    private static final Path SCENARIOS = Path.of("src/test/resources/scenarios");

    @ParameterizedTest
    @ValueSource(strings = {
            "AnySolutionWithMainMethod",
            "AnySolutionWithPrintStatements"
    })
    void global(String scenario) throws IOException {
        var path = Path.of("global", scenario + ".java");
        var solution = new SolutionFromFiles("unknown", SCENARIOS.resolve(path));
        var output = AnalyzerRoot.analyze(solution);

        Approvals.verify(serialize(output.analysis()), Approvals.NAMES.withParameters(scenario));
    }

    @ParameterizedTest
    @ValueSource(strings = {
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
    })
    void hamming(String scenario) throws IOException {
        var path = Path.of("hamming", scenario + ".java");
        var solution = new SolutionFromFiles("hamming", SCENARIOS.resolve(path));
        var output = AnalyzerRoot.analyze(solution);

        Approvals.verify(serialize(output.analysis()), Approvals.NAMES.withParameters(scenario));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "ExemplarSolution",
            "ExemplarSolutionWithTodoComments",
            "NoReuseOfExpectedMinutesInOven",
            "NoReuseOfPreparationTimeInMinutes",
            "NoReuseOfBothMethods"
    })
    void lasagna(String scenario) throws IOException {
        var path = Path.of("lasagna", scenario + ".java");
        var solution = new SolutionFromFiles("lasagna", SCENARIOS.resolve(path));
        var output = AnalyzerRoot.analyze(solution);

        Approvals.verify(serialize(output.analysis()), Approvals.NAMES.withParameters(scenario));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "OptimalSolution",
            "HardCodedTestCases",
            "UsingGregorianCalendar",
            "UsingIfStatements",
            "UsingJavaTime",
            "UsingTernary",
            "UsingTooManyChecks"
    })
    void leap(String scenario) throws IOException {
        var path = Path.of("leap", scenario + ".java");
        var solution = new SolutionFromFiles("leap", SCENARIOS.resolve(path));
        var output = AnalyzerRoot.analyze(solution);

        Approvals.verify(serialize(output.analysis()), Approvals.NAMES.withParameters(scenario));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "UsesLambda",
            "UsesLoop",
            "HardCodedTestCases",
            "NoConditionalLogic",
            "UsesStringFormat",
            "UsesMultipleReturns",
            "OptimalNoTernary",
            "Optimal"
    })
    public void twofer(String scenario) throws IOException {
        var path = Path.of("twofer", scenario + ".java");
        var solution = new SolutionFromFiles("two-fer", SCENARIOS.resolve(path));
        var output = AnalyzerRoot.analyze(solution);

        Approvals.verify(serialize(output.analysis()), Approvals.NAMES.withParameters(scenario));
    }
}
