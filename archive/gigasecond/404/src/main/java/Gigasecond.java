import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

	private LocalDateTime date;

	Gigasecond(LocalDate birthDate) {
		this.date = LocalDateTime.of(birthDate, LocalTime.MIDNIGHT).plusSeconds(1000000000);
	}

	Gigasecond(LocalDateTime birthDateTime) {
		this.date = birthDateTime.plusSeconds(1000000000);
	}

	LocalDateTime getDateTime() {
		return this.date;
	}

}
