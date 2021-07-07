import java.time.LocalDate;
import java.time.LocalDateTime;

/**
* The Gigasecond program takes a LocalDate or LocalDateTime value
* and provides a method to determine how much time has passed if
* a gigasecond (10^9 seconds) is added to that value.
* @author  Dave Goodchild
* @version 1.0
* @since   2019-06-18 
*/
class Gigasecond {
    private LocalDateTime localDateTime;
    private static final int INTERVAL = 1000000000;

    Gigasecond(LocalDate moment) {
        this.localDateTime = moment.atStartOfDay();;
    }

    Gigasecond(LocalDateTime moment) {
        this.localDateTime = moment;
    }

    LocalDateTime getDateTime() {
        return this.localDateTime.plusSeconds(Gigasecond.INTERVAL);
    }
}
