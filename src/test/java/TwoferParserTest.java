import analyzer.exercises.Twofer;
import org.junit.Test;

public class TwoferParserTest {
    @Test
    public void twoferTest() {
        new Twofer("archive/4/Twofer.java").parse();
    }
}
