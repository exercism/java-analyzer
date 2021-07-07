import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

	LocalDateTime nextMoment;

    Gigasecond(LocalDate moment) {
    	LocalDateTime currentMoment = moment.atStartOfDay();
    	this.nextMoment = currentMoment.plusSeconds(1000000000);
    }

    Gigasecond(LocalDateTime moment) {
    	this.nextMoment = moment.plusSeconds(1000000000);
    }

    LocalDateTime getDateTime() {
        return this.nextMoment;
    }

}
