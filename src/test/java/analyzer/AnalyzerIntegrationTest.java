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
            "AnySolutionWithPrintStatements",
    })
    void global(String scenario) throws IOException {
        var path = Path.of("global", scenario + ".java");
        var solution = new SolutionFromFiles("unknown", SCENARIOS.resolve(path));
        var output = AnalyzerRoot.analyze(solution);

        Approvals.verify(serialize(output.analysis()), Approvals.NAMES.withParameters(scenario));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "ConstructorTooLong",
            "MethodTooLong",
            "MustUseCharAtOrCodePointAt",
            "NestedCalculation",
            "NestedValidation",
            "OptimalWithCalculationDelegatedFromConstructor",
            "OptimalWithCalculationDelegatedFromGetHammingDistance",
            "OptimalWithCalculationInGetHammingDistance",
            "OptimalWithValidationMethod",
            "UsesCharacterLiterals",
            "UsesStreamReduce",
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
            "NoReuseOfBothMethods",
            "NoReuseOfExpectedMinutesInOven",
            "NoReuseOfPreparationTimeInMinutes",
    })
    void lasagna(String scenario) throws IOException {
        var path = Path.of("lasagna", scenario + ".java");
        var solution = new SolutionFromFiles("lasagna", SCENARIOS.resolve(path));
        var output = AnalyzerRoot.analyze(solution);

        Approvals.verify(serialize(output.analysis()), Approvals.NAMES.withParameters(scenario));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "HardCodedTestCases",
            "OptimalSolution",
            "UsingGregorianCalendar",
            "UsingIfStatements",
            "UsingJavaTime",
            "UsingTernary",
            "UsingTooManyChecks",
    })
    void leap(String scenario) throws IOException {
        var path = Path.of("leap", scenario + ".java");
        var solution = new SolutionFromFiles("leap", SCENARIOS.resolve(path));
        var output = AnalyzerRoot.analyze(solution);

        Approvals.verify(serialize(output.analysis()), Approvals.NAMES.withParameters(scenario));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "HardCodedTestCases",
            "Optimal",
            "OptimalNoTernary",
            "UsesMultipleReturns",
            "UsesStringFormat",
    })
    public void twofer(String scenario) throws IOException {
        var path = Path.of("twofer", scenario + ".java");
        var solution = new SolutionFromFiles("two-fer", SCENARIOS.resolve(path));
        var output = AnalyzerRoot.analyze(solution);

        Approvals.verify(serialize(output.analysis()), Approvals.NAMES.withParameters(scenario));
    }
}
