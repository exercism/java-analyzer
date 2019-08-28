import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    private LocalDateTime now;

    Gigasecond(LocalDate localDate) {
        this.now = localDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime localDateTime) {
        this.now = localDateTime;
    }

    LocalDateTime getDateTime() {
        long GIGASECONDS = 1000000000;
        return now.plusSeconds(GIGASECONDS);
    }

}