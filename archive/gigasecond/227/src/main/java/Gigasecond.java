import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
	
	LocalDateTime moment;

    Gigasecond(LocalDate moment) {
    	this.moment = moment.atStartOfDay(); //Convert LocalDate to LocalDateTime
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {  
    	this.moment = this.moment.plusSeconds(1000000000);  //Add 1 Gigasecond
    	return this.moment;
    }

}
