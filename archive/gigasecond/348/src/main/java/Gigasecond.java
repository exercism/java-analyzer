import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

	private LocalDateTime date;
	private long gigasecond = 1000000000L;

    Gigasecond(LocalDate birthDate) {
    	date = birthDate.atTime(0,0).plusSeconds(gigasecond);
	}

    Gigasecond(LocalDateTime birthDateTime) {
    	date = birthDateTime.plusSeconds(gigasecond);
    }

    LocalDateTime getDateTime() {
    	return date;
    }

}
