import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

	private LocalDateTime date;
	private final long gigasecond = 1000000000;

    Gigasecond(LocalDate birthDate) {
        if (birthDate != null) {
        	date = birthDate.atStartOfDay();
        }
    }

    Gigasecond(LocalDateTime birthDateTime) {
        if (birthDateTime != null) {
        	date = birthDateTime;
        }
    }

    LocalDateTime getDateTime() {
        return date.plusSeconds(gigasecond);
    }

}
