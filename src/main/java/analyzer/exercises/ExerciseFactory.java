package analyzer.exercises;

public interface ExerciseFactory {

    static ExerciseFactory get() {
        return new ReflectionBasedExerciseFactory();
    }

    Exercise create(final String slug, final String dir) throws ExerciseNotFoundException;

}
