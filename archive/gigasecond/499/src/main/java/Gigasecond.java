import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
	
	LocalDateTime date;
	
    Gigasecond(LocalDate birthDate) {
        date = birthDate.atStartOfDay().plusSeconds(1000000000);
    }

    Gigasecond(LocalDateTime birthDateTime) {
    	date = birthDateTime.plusSeconds(1000000000);
    }

    LocalDateTime getDateTime() {
        return date;
    }

}
