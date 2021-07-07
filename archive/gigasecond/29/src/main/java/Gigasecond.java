import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {
	
	private LocalDateTime localDateTime;

    Gigasecond(LocalDateTime moment) {
    	this.localDateTime = moment;
    }

    Gigasecond(LocalDate moment) {
    	this.localDateTime = moment.atTime(0, 0, 0);
    }

    LocalDateTime getDateTime() {     	
    	return this.localDateTime.plus(1000000000, ChronoUnit.SECONDS);
    }

}
