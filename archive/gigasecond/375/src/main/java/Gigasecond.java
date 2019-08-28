import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
	private LocalDateTime dateTime;
	long gig = 1000000000L;

    Gigasecond(LocalDate birthDate) {
   
    	dateTime = birthDate.atTime(0,0);
    	dateTime = dateTime.plus(Duration.ofSeconds(gig));

     }

    Gigasecond(LocalDateTime birthDateTime) {
   
    	dateTime = birthDateTime;
    	dateTime = dateTime.plus(Duration.ofSeconds(gig));

     }

    LocalDateTime getDateTime() {
    	return dateTime;
     }

}

