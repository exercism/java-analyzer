package analyzer.exercises;

import analyzer.comments.AvoidPrintStatements;
import analyzer.comments.DoNotUseMainMethod;
import analyzer.test.AnalyzerUnitTestBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GlobalAnalyzerTest extends AnalyzerUnitTestBase<GlobalAnalyzer> {
    GlobalAnalyzerTest() {
        super(GlobalAnalyzer::new);
    }

    @MethodSource
    @ParameterizedTest
    public void solutionsWithMainMethod(String code) {
        var output = analyze(code);
        assertThat(output.getComments()).contains(new DoNotUseMainMethod());
    }

    private static Stream<String> solutionsWithMainMethod() {
        return Stream.of(
                """
                        class Solution {
                            public static void main(String... args) {}
                        }""",
                """
                        class Solution {
                            public static void main(String ...args) {}
                        }""",
                """
                        class Solution {
                            public static void main(String[] args) {}
                        }"""
        );
    }

    @MethodSource
    @ParameterizedTest
    public void solutionsWithPrintStatements(String code) {
        var output = analyze(code);
        assertThat(output.getComments()).contains(new AvoidPrintStatements());
    }

    private static Stream<String> solutionsWithPrintStatements() {
        return Stream.of(
                """
                        class Solution {
                            void method() {
                                System.out.println("Printing line to stdout");
                            }
                        }""",
                """
                        class Solution {
                            void method() {
                                System.err.println("Printing line to stderr");
                            }
                        }""",
                """
                        class Solution {
                            void method() {
                                System.out.print("Printing to stdout");
                            }
                        }""",
                """
                        class Solution {
                            void method() {
                                System.err.print("Printing to stderr");
                            }
                        }"""
        );
    }
}
