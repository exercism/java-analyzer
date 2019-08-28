import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {
	private static final int EXTRA_SECONDS = 1000000000;
	private final LocalDateTime time;
	private final LocalDateTime newTime;

    Gigasecond(LocalDate moment) {
        time = LocalDateTime.of(moment, LocalTime.MIDNIGHT);
        newTime = time.plusSeconds(EXTRA_SECONDS);
    }

    Gigasecond(LocalDateTime moment) {
        time = moment;
        newTime = time.plusSeconds(EXTRA_SECONDS);
    }

    LocalDateTime getDateTime() {
        return newTime;
    }

}
