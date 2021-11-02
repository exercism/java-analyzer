package analyzer.exercises;

import javax.annotation.Nullable;

/**
 * Enumeration of currently supported exercises.
 */
public enum SupportedExercise {
    HAMMING("hamming", "Hamming.java", "analyzer.exercises.hamming.Hamming"),
    TWO_FER("two-fer", "Twofer.java", "analyzer.exercises.twofer.Twofer");

    public final String slug;
    public final String fileName;
    public final String className;

    SupportedExercise(String slug, String fileName, String className) {
        this.slug = slug;
        this.fileName = fileName;
        this.className = className;
    }

    public static @Nullable
    SupportedExercise getBySlug(String slug) {
        for (SupportedExercise v : SupportedExercise.values()) {
            if (v.slug.equals(slug)) {
                return v;
            }
        }
        return null;
    }
}
