import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

	private final LocalDateTime dateOfBirth;
	
    Gigasecond(LocalDate birthDate) {
    	this.dateOfBirth = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
    	this.dateOfBirth = birthDateTime;
    }

    LocalDateTime getDateTime() {
    return dateOfBirth.plusSeconds(1000000000);
    }

}
