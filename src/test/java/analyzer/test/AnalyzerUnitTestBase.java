package analyzer.test;

import analyzer.Analyzer;
import analyzer.OutputCollector;
import analyzer.Solution;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Supplier;

/**
 * Base class for unit testing individual analyzers.
 */
public abstract class AnalyzerUnitTestBase {
    private final Supplier<Analyzer> createAnalyzer;
    private Analyzer analyzer;

    protected AnalyzerUnitTestBase(Supplier<Analyzer> createAnalyzer) {
        this.createAnalyzer = createAnalyzer;
    }

    @BeforeEach
    protected void setup() {
        analyzer = createAnalyzer.get();
    }

    protected OutputCollector analyze(String code) {
        return analyze(new SolutionFromString("", code));
    }

    protected OutputCollector analyze(Path... files) throws IOException {
        return analyze(new SolutionFromFiles("", files));
    }

    private OutputCollector analyze(Solution solution) {
        var collector = new FakeOutputCollector();
        this.analyzer.analyze(solution, collector);
        return collector;
    }
}
