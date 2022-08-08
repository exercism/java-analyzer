package analyzer.analyzerInterfaces;

import java.util.List;
import java.util.Optional;

public interface Output {

    Optional<String> summary();

    // Could be an array or list
    List<String> comment();

    /*
     * Makes the output ready to be processed
     * @param options the execution options
     * @returns the output as a string
     */
    String toProcessable();
    // TODO: revisit how it's done in the JS analyzer because it calls on ExecutionOptions

}
