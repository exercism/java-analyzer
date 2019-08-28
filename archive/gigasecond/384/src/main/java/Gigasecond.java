import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
	
	private final static long GIGASECOND = 1000000000;
	
	private final LocalDateTime timeProvided; 

    Gigasecond(LocalDate birthDate) {
        timeProvided = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        timeProvided = birthDateTime;
    }

    LocalDateTime getDateTime() {
		return timeProvided.plusSeconds(GIGASECOND);
    }

}
