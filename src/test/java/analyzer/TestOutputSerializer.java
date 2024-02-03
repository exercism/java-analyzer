package analyzer;

import org.approvaltests.strings.Printable;

import static analyzer.OutputSerializer.serialize;

public class TestOutputSerializer {
    public static Printable<Output.Analysis> printable(Output.Analysis analysis) {
        return new Printable<>(analysis, serialize(analysis));
    }

    public static Printable<Output.Tags> printable(Output.Tags tags) {
        return new Printable<>(tags, serialize(tags));
    }
}
