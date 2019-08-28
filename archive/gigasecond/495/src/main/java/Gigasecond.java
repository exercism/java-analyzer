import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
	private LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
    	this.birthDateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
    	this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
    	return birthDateTime.plusSeconds((long)Math.pow(10, 9));
    }

}
