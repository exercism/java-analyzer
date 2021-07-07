import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {
	private LocalDate localDate;
	private LocalDateTime localDateTime;
	
	private static final int GIGASECOND = 1000000000;

	Gigasecond(LocalDate moment) {
		this.localDate = moment;
		this.localDateTime = LocalDateTime.of(moment, LocalTime.now());
	}

	Gigasecond(LocalDateTime moment) {
		this.localDateTime = moment;
	}

	LocalDateTime getDateTime() {
		return this.localDateTime.plus(GIGASECOND, ChronoUnit.SECONDS);
	}

}
