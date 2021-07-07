import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    Gigasecond(LocalDate moment) {
    	ldt = LocalDateTime.of(moment, LocalTime.of(0,  0, 0));
    }

    Gigasecond(LocalDateTime moment) {
        ldt = moment;
    }

    LocalDateTime getDateTime() {
        return ldt.plusSeconds(1_000_000_000);
    }

    private LocalDateTime ldt;
}
