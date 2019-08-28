import java.time.LocalDate;
import java.time.LocalDateTime;

//import com.sun.javafx.geom.AreaOp.AddOp;

public class Gigasecond {

    LocalDate input = null;

    LocalDateTime inputwithtime = null;

    Gigasecond(LocalDate moment) {
        this.input = moment;
    }

    Gigasecond(LocalDateTime moment) {
        this.inputwithtime = moment;
    }

    LocalDateTime getDateTime() {
        LocalDateTime t;
        if (inputwithtime == null) {
            t = this.input.atStartOfDay();
        }
        else {
            t = this.inputwithtime;
        }
        return t.plusSeconds(1000000000);
    }
}