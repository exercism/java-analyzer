import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

	int gigasecond = 1_000_000_000;
	LocalDateTime dateTime;

	Gigasecond(LocalDate moment) {
		LocalDateTime date = moment.atStartOfDay();
		this.dateTime = date.plusSeconds(this.gigasecond);
	}

	Gigasecond(LocalDateTime moment) {
		this.dateTime = moment.plusSeconds(this.gigasecond);
	}

	LocalDateTime getDateTime() {
		return this.dateTime;
	}

}
