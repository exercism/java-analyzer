import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

	private LocalDateTime localDateTime;
	private final long SECONDS = 1000000000; // 1 gigasecond == 1000000000 seconds.

	Gigasecond(LocalDate moment) {
		localDateTime = LocalDateTime.of(moment, LocalTime.of(0, 0, 0)).plus(SECONDS, ChronoUnit.SECONDS);
	}

	Gigasecond(LocalDateTime moment) {
		localDateTime = moment.plus(SECONDS, ChronoUnit.SECONDS);
	}

	LocalDateTime getDateTime() {
		return localDateTime;
	}

}
