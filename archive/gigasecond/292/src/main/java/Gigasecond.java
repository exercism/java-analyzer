import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

class Gigasecond {

	private LocalDateTime time;

    Gigasecond(LocalDate birthDate) {
        time = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
     	time = birthDateTime;
    }

    LocalDateTime getDateTime() {
    	return time.plusSeconds(1000000000L);
    }
}