import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
	LocalDateTime dateTime;
    Gigasecond(LocalDate birthDate) {
    	this.dateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
    	this.dateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
    	return dateTime;
	}

}
