package analyzer.analyzerInterfaces;

import java.util.ArrayList;
import java.util.Optional;

public interface AnalyzerComment {

    // Constructed message with all the template variables applied.
    String message();

    // The message with template variables in there.
    String template();

    // The identifier for the template on website-copy.
    String externalTemplate();

    // Not sure if this should be a map
    ArrayList<String> variables();

    // The type of comment.
    Optional<?> commentType();
}
