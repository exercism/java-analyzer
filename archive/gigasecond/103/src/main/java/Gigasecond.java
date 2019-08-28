import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
	
	private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = LocalDateTime.of(moment.getYear(), moment.getMonth(), moment.getDayOfMonth(), 0, 0, 0);
        this.moment = this.moment.plusSeconds(1000000000);
    }

    Gigasecond(LocalDateTime moment) {
    	this.moment = moment.plusSeconds(1000000000);
    }

    LocalDateTime getDateTime() {
        return this.moment;
    }

}
