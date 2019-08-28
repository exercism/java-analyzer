import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
	private static long GIGA = 1000000000;
	private LocalDateTime ldt;
	
    Gigasecond(LocalDate moment) {
    	this.ldt = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
    	this.ldt = moment;
    }

    LocalDateTime getDateTime() {
        return ldt.plusSeconds(GIGA);
    }

}
