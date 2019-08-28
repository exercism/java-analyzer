import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

	private LocalDateTime result;

	Gigasecond(LocalDate moment) {
		result = moment.atStartOfDay().plusSeconds(1000000000);
	}

	Gigasecond(LocalDateTime moment) {
		result = moment.plusSeconds(1000000000);
	}

	LocalDateTime getDateTime() {
		return result;
	}
}
