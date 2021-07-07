import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

	LocalDateTime birthdate= null;
    Gigasecond(LocalDate birthDate) {
    	this.birthdate = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
    	this.birthdate = birthDateTime;
    }

    LocalDateTime getDateTime() {
    	return birthdate.plusSeconds((long)Math.pow(10, 9));
    }

}
