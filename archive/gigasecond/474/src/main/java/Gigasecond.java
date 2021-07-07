import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;


class Gigasecond {
	
	private LocalDate birthDate;
	private LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
    	
      this.birthDate = birthDate;
       
    }

    Gigasecond(LocalDateTime birthDateTime) {
       
        this.birthDateTime = birthDateTime;
    }

    long getDateTime() {
      Duration dur =  Duration.between(birthDateTime, LocalDateTime.now());
	return dur.getNano() * 1000;
    	
    	
    	
    }

}