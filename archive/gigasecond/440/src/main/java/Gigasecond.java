import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
	private LocalDateTime dateResult;
	private LocalDateTime date;

	Gigasecond(LocalDate birthDate) {
		date = birthDate.atStartOfDay();
		dateResult = date.plusSeconds((int) Math.pow(10, 9));
	}

	Gigasecond(LocalDateTime birthDateTime) {
		dateResult = birthDateTime.plusSeconds((int) Math.pow(10, 9));
	}

	LocalDateTime getDateTime() {
		return dateResult;
	}
}
