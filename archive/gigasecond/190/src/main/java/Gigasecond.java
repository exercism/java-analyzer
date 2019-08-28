import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {
	private static final long GIGASECOND = 1_000_000_000;
	private final LocalDateTime moment;
	
    Gigasecond(LocalDate moment) {
        this.moment = LocalDateTime.of(moment, LocalTime.of(0, 0, 0));
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return moment.plus(GIGASECOND, ChronoUnit.SECONDS);
    }

}
