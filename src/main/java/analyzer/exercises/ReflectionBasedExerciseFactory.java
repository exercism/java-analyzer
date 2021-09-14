package analyzer.exercises;

import org.intellij.lang.annotations.Language;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ReflectionBasedExerciseFactory implements ExerciseFactory {

    private static final String EXERCISE_PACKAGE_PREFIX = "analyzer.exercises.";

    @Language("RegExp")
    private static final String SLUG_SPLIT_REGEX = "-";

    @Override
    public Exercise create(final String slug, final String dir) throws ExerciseNotFoundException {
        final String[] slugParts = slug.split(SLUG_SPLIT_REGEX);
        final String exercisePackage = convertSlugPartsToPackage(slugParts);
        final String exerciseClass = convertSlugPartsToClassName(slugParts);
        final String fullyQualifierExerciseClass = EXERCISE_PACKAGE_PREFIX + exercisePackage + "." + exerciseClass;
        Class<?> exerciseClazz;
        try {
            exerciseClazz = Class.forName(fullyQualifierExerciseClass);
        } catch (ClassNotFoundException e) {
            throw new ExerciseNotFoundException("No analyzer found for " + slug + "!");
        }
        try {
            Constructor<?> constructor = exerciseClazz.getConstructor(String.class);
            return (Exercise) constructor.newInstance(dir);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new ExerciseNotFoundException("No analyzer found for " + slug + "!");
        }
    }

    private String convertSlugPartsToPackage(final String[] slugParts) {
        return Arrays.stream(slugParts)
                .map(String::toLowerCase)
                .collect(Collectors.joining());
    }

    private String convertSlugPartsToClassName(final String[] slugParts) {
        return Arrays.stream(slugParts)
                .map(this::capitalize)
                .collect(Collectors.joining());
    }

    private String capitalize(final String string) {
        if (string.isEmpty()) {
            return string;
        }
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }

}
