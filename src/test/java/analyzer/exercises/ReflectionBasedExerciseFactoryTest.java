package analyzer.exercises;

import analyzer.exercises.hamming.Hamming;
import analyzer.exercises.twofer.TwoFer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class ReflectionBasedExerciseFactoryTest {

    private ExerciseFactory exerciseFactory;

    //TODO: Find a way to make this work
    private final String SOME_DIR = ReflectionBasedExerciseFactoryTest.class.getResource("/factory/").toExternalForm();

    @Before
    public void setUp() throws Exception {
        exerciseFactory = new ReflectionBasedExerciseFactory();
    }

    @Test(expected = ExerciseNotFoundException.class)
    public void testSlugWithoutAnalyzer() throws Exception {
        // Arrange
        final String slug = "slug-with-no-analyzer";

        // Act
        exerciseFactory.create(slug, SOME_DIR);
    }

    @Test
    public void testTwoFer() throws Exception {
        // Arrange
        final String slug = "two-fer";

        // Act
        final Exercise exercise = exerciseFactory.create(slug, SOME_DIR);

        // Assert
        assertThat(exercise, instanceOf(TwoFer.class));
    }

    @Test
    public void testHamming() throws Exception {
        // Arrange
        final String slug = "hamming";

        // Act
        final Exercise exercise = exerciseFactory.create(slug, SOME_DIR);

        // Assert
        assertThat(exercise, instanceOf(Hamming.class));
    }
}