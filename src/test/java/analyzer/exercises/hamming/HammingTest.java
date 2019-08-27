package analyzer.exercises.hamming;

import static com.google.common.truth.Truth.assertThat;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import analyzer.exercises.Exercise;

public class HammingTest {
    private static final int INDENTATION_LEVEL = 1;

    @Test
    public void noHammingClass() {
        Exercise hamming =
            new Hamming(getTestFileFromResource("NoHammingClass.java.txt"));
        hamming.parse();

        assertThat(hamming.getAnalysis().toString(INDENTATION_LEVEL))
            .isEqualTo(
                new JSONObject()
                    .put("status", "disapprove")
                    .put("comments",
                        new JSONArray()
                            .put(
                                new JSONObject()
                                    .put("comment", "java.general.use_proper_class_name")
                                    .put("params", new JSONObject().put("className", "Hamming"))))
                    .toString(INDENTATION_LEVEL));
    }

    @Test
    public void noGetHammingDistanceMethod() {
        Exercise hamming =
            new Hamming(getTestFileFromResource("NoGetHammingDistanceMethod.java.txt"));
        hamming.parse();

        assertThat(hamming.getAnalysis().toString(INDENTATION_LEVEL))
            .isEqualTo(
                new JSONObject()
                    .put("status", "disapprove")
                    .put("comments",
                        new JSONArray()
                            .put(
                                new JSONObject()
                                    .put("comment", "java.general.use_proper_method_name")
                                    .put("params", new JSONObject().put("methodName", "getHammingDistance"))))
                    .toString(INDENTATION_LEVEL));
    }

    @Test
    public void noConstructor() {
        Exercise hamming =
            new Hamming(getTestFileFromResource("NoConstructor.java.txt"));
        hamming.parse();

        assertThat(hamming.getAnalysis().toString(INDENTATION_LEVEL))
            .isEqualTo(
                new JSONObject()
                    .put("status", "disapprove")
                    .put("comments", new JSONArray().put("java.hamming.must_use_constructor"))
                    .toString(INDENTATION_LEVEL));
    }

    @Test
    public void noConditionalInConstructor() {
        Exercise hamming =
            new Hamming(getTestFileFromResource("NoConditionalInConstructor.java.txt"));
        hamming.parse();

        assertThat(hamming.getAnalysis().toString(INDENTATION_LEVEL))
            .isEqualTo(
                new JSONObject()
                    .put("status", "disapprove")
                    .put(
                        "comments",
                        new JSONArray()
                            .put("java.hamming.must_use_conditional_logic_in_constructor"))
                    .toString(INDENTATION_LEVEL));
    }

    @Test
    public void doesNotThrowInConstructor() {
        Exercise hamming =
            new Hamming(getTestFileFromResource("DoesNotThrowInConstructor.java.txt"));
        hamming.parse();

        assertThat(hamming.getAnalysis().toString(INDENTATION_LEVEL))
            .isEqualTo(
                new JSONObject()
                    .put("status", "disapprove")
                    .put(
                        "comments",
                        new JSONArray().put("java.hamming.must_throw_in_constructor"))
                    .toString(INDENTATION_LEVEL));
    }

    @Test
    public void noCalculationOfHammingDistance() {
        Exercise hamming =
            new Hamming(getTestFileFromResource("NoCalculationOfHammingDistance.java.txt"));
        hamming.parse();

        assertThat(hamming.getAnalysis().toString(INDENTATION_LEVEL))
            .isEqualTo(
                new JSONObject()
                    .put("status", "disapprove")
                    .put(
                        "comments",
                        new JSONArray().put("java.hamming.must_calculate_hamming_distance"))
                    .toString(INDENTATION_LEVEL));
    }

    @Test
    public void usesCharacterLiterals() {
        Exercise hamming =
            new Hamming(getTestFileFromResource("UsesCharacterLiterals.java.txt"));
        hamming.parse();

        assertThat(hamming.getAnalysis().toString(INDENTATION_LEVEL))
            .isEqualTo(
                new JSONObject()
                    .put("status", "disapprove")
                    .put(
                        "comments",
                        new JSONArray().put("java.hamming.avoid_character_literals"))
                    .toString(INDENTATION_LEVEL));
    }

    @Test
    public void mustUseCharAtOrCodePointAt() {
        Exercise hamming =
            new Hamming(
                getTestFileFromResource(
                    "MustUseCharAtOrCodePointAt.java.txt"));
        hamming.parse();

        assertThat(hamming.getAnalysis().toString(INDENTATION_LEVEL))
            .isEqualTo(
                new JSONObject()
                    .put("status", "disapprove")
                    .put(
                        "comments",
                        new JSONArray().put("java.hamming.must_use_string_char_at_or_code_point_at"))
                    .toString(INDENTATION_LEVEL));
    }

    @Test
    public void nestedValidation() {
        Exercise hamming =
            new Hamming(getTestFileFromResource("NestedValidation.java.txt"));
        hamming.parse();

        assertThat(hamming.getAnalysis().toString(INDENTATION_LEVEL))
            .isEqualTo(
                new JSONObject()
                    .put("status", "approve")
                    .put(
                        "comments",
                        new JSONArray().put("java.hamming.calculate_distance_in_constructor"))
                    .toString(INDENTATION_LEVEL));
    }

    @Test
    public void nestedCalculation() {
        Exercise hamming =
            new Hamming(getTestFileFromResource("NestedCalculation.java.txt"));
        hamming.parse();

        assertThat(hamming.getAnalysis().toString(INDENTATION_LEVEL))
            .isEqualTo(new JSONObject().put("status", "approve").toString(INDENTATION_LEVEL));
    }

    @Test
    public void shouldUseIsEmpty() {
        Exercise hamming =
            new Hamming(
                getTestFileFromResource(
                    "ShouldUseStringIsEmpty.java.txt"));
        hamming.parse();

        assertThat(hamming.getAnalysis().toString(INDENTATION_LEVEL))
            .isEqualTo(
                new JSONObject()
                    .put("status", "approve")
                    .put(
                        "comments",
                        new JSONArray().put("java.hamming.should_use_string_is_empty"))
                    .toString(INDENTATION_LEVEL));
    }

    @Test
    public void optimalWithCalculationInGetHammingDistance() {
        Exercise hamming =
            new Hamming(
                getTestFileFromResource(
                    "OptimalWithCalculationInGetHammingDistance.java.txt"));
        hamming.parse();

        assertThat(hamming.getAnalysis().toString(INDENTATION_LEVEL))
            .isEqualTo(
                new JSONObject()
                    .put("status", "approve")
                    .put(
                        "comments",
                        new JSONArray().put("java.hamming.calculate_distance_in_constructor"))
                    .toString(INDENTATION_LEVEL));
    }

    @Test
    public void optimalWithCalculationDelegatedFromGetHammingDistance() {
        Exercise hamming =
            new Hamming(
                getTestFileFromResource(
                    "OptimalWithCalculationDelegatedFromGetHammingDistance.java.txt"));
        hamming.parse();

        assertThat(hamming.getAnalysis().toString(INDENTATION_LEVEL))
            .isEqualTo(
                new JSONObject()
                    .put("status", "approve")
                    .put(
                        "comments",
                        new JSONArray().put("java.hamming.calculate_distance_in_constructor"))
                    .toString(INDENTATION_LEVEL));
    }

    @Test
    public void constructorTooLong() {
        Exercise hamming =
            new Hamming(
                getTestFileFromResource("ConstructorTooLong.java.txt"));
        hamming.parse();

        assertThat(hamming.getAnalysis().toString(INDENTATION_LEVEL))
            .isEqualTo(
                new JSONObject()
                    .put("status", "approve")
                    .put(
                        "comments",
                        new JSONArray().put("java.general.constructor_too_long"))
                    .toString(INDENTATION_LEVEL));
    }

    @Test
    public void methodTooLong() {
        Exercise hamming =
            new Hamming(
                getTestFileFromResource("MethodTooLong.java.txt"));
        hamming.parse();

        assertThat(hamming.getAnalysis().toString(INDENTATION_LEVEL))
            .isEqualTo(
                new JSONObject()
                    .put("status", "approve")
                    .put(
                        "comments",
                        new JSONArray().put("java.general.method_too_long"))
                    .toString(INDENTATION_LEVEL));
    }

    @Test
    public void optimalWithCalculationDelegatedFromConstructor() {
        Exercise hamming =
            new Hamming(
                getTestFileFromResource(
                    "OptimalWithCalculationDelegatedFromConstructor.java.txt"));
        hamming.parse();

        assertThat(hamming.getAnalysis().toString(INDENTATION_LEVEL))
            .isEqualTo(
                new JSONObject().put("status", "approve").toString(INDENTATION_LEVEL));
    }

    @Test
    public void optimalWithValidationMethod() {
        Exercise hamming =
            new Hamming(getTestFileFromResource("OptimalWithValidationMethod.java.txt"));
        hamming.parse();

        assertThat(hamming.getAnalysis().toString(INDENTATION_LEVEL))
            .isEqualTo(
                new JSONObject().put("status", "approve").toString(INDENTATION_LEVEL));
    }

    private File getTestFileFromResource(String testFileName) {
        return new File(
            getClass()
                .getResource("/analyzer/exercises/hamming/" + testFileName)
                .getFile());
    }
}