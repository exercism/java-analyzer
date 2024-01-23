package analyzer;

import com.github.javaparser.ast.CompilationUnit;

import java.util.List;

/**
 * This represents the solution to an exercise.
 */
public interface Solution {
    /**
     * Get the slug of the exercise to which the solution belongs.
     *
     * @return Exercise slug.
     */
    String getSlug();

    /**
     * Get the parsed Java files that are part of the solution.
     *
     * @return List of compilation units.
     */
    List<CompilationUnit> getCompilationUnits();
}
