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

    @ParameterizedTest
    @ValueSource(strings = {
            "Optimal",
            "ComparingBooleanWithLiteral",
            "ReturningBooleanLiteral",
            "UsingIfStatement",
            "UsingRedundantParenthesis",
    })
    public void annalynsinfiltration(String scenario) throws IOException {
        var path = Path.of("annalynsinfiltration", scenario + ".java");
        var solution = new SolutionFromFiles("annalyns-infiltration", SCENARIOS.resolve(path));
        var output = AnalyzerRoot.analyze(solution);

        Approvals.verify(serialize(output.analysis()), Approvals.NAMES.withParameters(scenario));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "ExemplarSolution",
            "UsingForLoop",
            "UsingIfStatement",
            "UsingTernary",
            "UsingWhileLoop",
    })
    void needforspeed(String scenario) throws IOException {
        var path = Path.of("need-for-speed", scenario + ".java");
        var solution = new SolutionFromFiles("need-for-speed", SCENARIOS.resolve(path));
        var output = AnalyzerRoot.analyze(solution);

        Approvals.verify(serialize(output.analysis()), Approvals.NAMES.withParameters(scenario));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "ExemplarSolution",
            "HardCodingLogLevelsUpperCase",
            "HardCodingLogLevelsLowerCase",
            "NoReuseLogLevel",
            "NoReuseMessage",
            "NoReuseOfBothMethods",
            "NotUsingExpectedMethodsOnLogLevel",
            "NotUsingExpectedMethodsOnMessage",
            "NotUsingExpectedMethodsOnLogLevelAndMessage",
            "UsingStringFormat"
    })
    void loglevels(String scenario) throws IOException {
        var path = Path.of("log-levels", scenario + ".java");
        var solution = new SolutionFromFiles("log-levels", SCENARIOS.resolve(path));
        var output = AnalyzerRoot.analyze(solution);

        Approvals.verify(serialize(output.analysis()), Approvals.NAMES.withParameters(scenario));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "ExemplarSolution",
            "NotUsingBitwiseAnd",
            "NotUsingBitwiseNot",
            "NotUsingBitwiseOr",
            "NotUsingBitwiseXor",
            "NotUsingUnsignedRightShift",
            "UsingIfStatement",
            "NotUsingAnyOfTheExpectedOperators"
    })
    void secrets(String scenario) throws IOException {
        var path = Path.of("secrets", scenario + ".java");
        var solution = new SolutionFromFiles("secrets", SCENARIOS.resolve(path));
        var output = AnalyzerRoot.analyze(solution);

        Approvals.verify(serialize(output.analysis()), Approvals.NAMES.withParameters(scenario));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "ExemplarSolution",
            "ExemplarSolutionWithTodoComments",
            "NotUsingOverrideAnnotations",
            "UsingAditionalEqualsMethodOverrided"
    })
    void wizardsandwarriors(String scenario) throws IOException {
        var path = Path.of("wizards-and-warriors", scenario + ".java");
        var solution = new SolutionFromFiles("wizards-and-warriors", SCENARIOS.resolve(path));
        var output = AnalyzerRoot.analyze(solution);

        Approvals.verify(serialize(output.analysis()), Approvals.NAMES.withParameters(scenario));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "ExemplarSolution",
            "NoReuseBonusForProductsSold",
            "NoReuseBonusMultiplier",
            "NoReuseSalaryMultiplier",
            "NotReusingMethodsAtAll",
            "NotUsingTernaryOperatorsAndNotReusingMethods",
            "NotUsingTernaryOperatorsAtAll",
            "NotUsingTernaryOperatorsOnBonusMultiplier",
            "NotUsingTernaryOperatorsOnFinalSalary",
            "NotUsingTernaryOperatorsOnSalaryMultiplier"
    })
    void salarycalculator(String scenario) throws IOException {
        var path = Path.of("salary-calculator", scenario + ".java");
        var solution = new SolutionFromFiles("salary-calculator", SCENARIOS.resolve(path));
        var output = AnalyzerRoot.analyze(solution);

        Approvals.verify(serialize(output.analysis()), Approvals.NAMES.withParameters(scenario));
    }
}
