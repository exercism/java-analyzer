import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
		
	private final LocalDateTime birth;
	private static final long SECONDS = 1_000_000_000;
	
	//constructor with date only
    Gigasecond(LocalDate moment) {
        this.birth = moment.atStartOfDay();
    }

    //constructor with date and time
    Gigasecond(LocalDateTime moment) {
        this.birth = moment;
    }

    //add time 10^9 seconds
    LocalDateTime getDateTime() {
    	LocalDateTime secondsAdded = birth.plusSeconds(SECONDS);
    	return secondsAdded;
    }
    

}
