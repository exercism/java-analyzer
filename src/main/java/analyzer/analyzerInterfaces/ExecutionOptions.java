package analyzer.analyzerInterfaces;

public interface ExecutionOptions {

    boolean debug();

    boolean console();

    boolean dry();

    String output();

    String inputDir();

    String exercise();

    boolean noTemplates();

    boolean prettyJSON();
}
