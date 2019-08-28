import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

     LocalDateTime time = null;
    int gigasecond=1000000000;
    Gigasecond(LocalDate birthDate) {
    	time = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
    	time = birthDateTime;
    }

    LocalDateTime getDateTime() {
    	return time.plusSeconds(gigasecond);
    }

}
