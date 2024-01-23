package analyzer;

import java.util.function.Supplier;

public class AnalyzerTestHelper {
    public static Analysis analyze(Solution solution, Supplier<Analyzer> analyzerSupplier) {
        var analysis = new Analysis();
        analyzerSupplier.get().analyze(solution, analysis);
        return analysis;
    }
}
