package analyzer.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExerciseRegistry {
    private static final Map<String, Function<String, Exercise>> registry = new HashMap<>();

    public static void register(String slug, Function<String, Exercise> exerciseCtor) {
        registry.put(slug, exerciseCtor);
    }

    public static Exercise getExercise(String slug, String dir) {
        if (registry.containsKey(slug)) {
            return registry.get(slug).apply(dir);
        }
        throw new IllegalArgumentException("Exercise not found: " + slug);
    }
}
