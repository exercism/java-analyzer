import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final long INCREMENT = 1000000000;
    private LocalDateTime ts; 
	
	Gigasecond(LocalDate birthDate) {
		this.ts = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
    	this.ts = birthDateTime;
    }

    LocalDateTime getDateTime() {
    	return this.ts.plusSeconds(INCREMENT);
    }

}
