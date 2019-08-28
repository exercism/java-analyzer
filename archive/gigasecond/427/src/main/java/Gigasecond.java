import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

	private static final int gigasecondSpan = 1000000000;
	private LocalDateTime birthDateTime;
	
    Gigasecond(LocalDate birthDate) {
    	this.birthDateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
    	this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
    	return birthDateTime.plusSeconds(gigasecondSpan);
    }

}
