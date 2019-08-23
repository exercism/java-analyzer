package analyzer.exercises.twofer;

import static com.google.common.truth.Truth.assertThat;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import analyzer.exercises.Exercise;

public class TwoferTest {
    @Test
    public void noTwoferClass() {
        Exercise twofer =
            new Twofer(getTestFileFromResource("NoTwoferClass.java.txt"));
        twofer.parse();

        assertThat(twofer.getAnalysis().toString())
            .isEqualTo(
                new JSONObject()
                    .put("status", "disapprove")
                    .put("comments",
                        new JSONArray()
                            .put(
                                new JSONObject()
                                    .put("comment", "java.general.use_proper_class_name")
                                    .put("params", new JSONObject().put("className", "Twofer"))))
                    .toString());
    }

    @Test
    public void noTwoferMethod() {
        Exercise twofer =
            new Twofer(getTestFileFromResource("NoTwoferMethod.java.txt"));
        twofer.parse();

        assertThat(twofer.getAnalysis().toString())
            .isEqualTo(
                new JSONObject()
                    .put("status", "disapprove")
                    .put("comments",
                        new JSONArray()
                            .put(
                                new JSONObject()
                                    .put("comment", "java.general.use_proper_method_name")
                                    .put("params", new JSONObject().put("methodName", "twofer"))))
                    .toString());
    }

    @Test
    public void usesLambda() {
        Exercise twofer =
            new Twofer(getTestFileFromResource("UsesLambda.java.txt"));
        twofer.parse();

        assertThat(twofer.getAnalysis().toString())
            .isEqualTo(new JSONObject().put("status", "refer_to_mentor").toString());
    }

    @Test
    public void usesLoop() {
        Exercise twofer =
            new Twofer(getTestFileFromResource("UsesLoop.java.txt"));
        twofer.parse();

        assertThat(twofer.getAnalysis().toString())
            .isEqualTo(new JSONObject().put("status", "refer_to_mentor").toString());
    }

    @Test
    public void hardCodedTestCases() {
        Exercise twofer =
            new Twofer(getTestFileFromResource("HardCodedTestCases.java.txt"));
        twofer.parse();

        assertThat(twofer.getAnalysis().toString())
            .isEqualTo(
                new JSONObject()
                    .put("status", "disapprove")
                    .put("comments",
                        new JSONArray().put("java.general.avoid_hard_coded_test_cases"))
                    .toString());
    }

    @Test
    public void noConditionalLogic() {
        Exercise twofer =
            new Twofer(getTestFileFromResource("NoConditionalLogic.java.txt"));
        twofer.parse();

        assertThat(twofer.getAnalysis().toString())
            .isEqualTo(
                new JSONObject()
                    .put("status", "disapprove")
                    .put("comments",
                        new JSONArray().put("java.two-fer.use_conditional_logic"))
                    .toString());
    }

    @Test
    public void usesStringFormat() {
        Exercise twofer =
            new Twofer(getTestFileFromResource("UsesStringFormat.java.txt"));
        twofer.parse();

        assertThat(twofer.getAnalysis().toString())
            .isEqualTo(
                new JSONObject()
                    .put("status", "disapprove")
                    .put("comments",
                        new JSONArray().put("java.two-fer.avoid_string_format"))
                    .toString());
    }

    @Test
    public void usesMultipleReturns() {
        Exercise twofer =
            new Twofer(getTestFileFromResource("UsesMultipleReturns.java.txt"));
        twofer.parse();

        assertThat(twofer.getAnalysis().toString())
            .isEqualTo(
                new JSONObject()
                    .put("status", "disapprove")
                    .put("comments",
                        new JSONArray().put("java.two-fer.use_one_return"))
                    .toString());
    }

    @Test
    public void optimalNoTernary() {
        Exercise twofer =
            new Twofer(getTestFileFromResource("OptimalNoTernary.java.txt"));
        twofer.parse();

        assertThat(twofer.getAnalysis().toString())
            .isEqualTo(
                new JSONObject()
                    .put("status", "approve")
                    .put("comments",
                        new JSONArray().put("java.two-fer.use_ternary_operator"))
                    .toString());
    }

    @Test
    public void optimal() {
        Exercise twofer =
            new Twofer(getTestFileFromResource("Optimal.java.txt"));
        twofer.parse();

        assertThat(twofer.getAnalysis().toString())
            .isEqualTo(new JSONObject().put("status", "approve").toString());
    }

    private File getTestFileFromResource(String testFileName) {
        return new File(
            getClass()
                .getResource("/analyzer/exercises/twofer/" + testFileName)
                .getFile());
    }
}