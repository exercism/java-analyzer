import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

	private LocalDate birthDate;
	private LocalDateTime birthDateTime;
	
	private final int GIGASECOND = 1000000000;
	
    Gigasecond(LocalDate birthDate) {

    	this.birthDate = birthDate;
    	this.birthDateTime = birthDate.atStartOfDay();
    	
    }

    Gigasecond(LocalDateTime birthDateTime) {
    	
    	this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
    	
    	return birthDateTime.plusSeconds(GIGASECOND);
    }
}
