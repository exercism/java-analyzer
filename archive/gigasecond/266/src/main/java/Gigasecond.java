import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

	private LocalDateTime start;
	
    Gigasecond(LocalDate moment) {
        start = moment.atStartOfDay();
    }	

    Gigasecond(LocalDateTime moment) {
    	start = moment;
    }

    LocalDateTime getDateTime() {
        return start.plusSeconds((long)Math.pow(10, 9));
    }

}
