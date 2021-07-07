import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    
    private final long GIGASECOND = 1_000_000_000L;
    private LocalDateTime momentPlusGigasecond;

    Gigasecond(LocalDate moment) {
	    this.momentPlusGigasecond = moment.atStartOfDay().plusSeconds(GIGASECOND);
    }

    Gigasecond(LocalDateTime moment) {
	    this.momentPlusGigasecond = moment.plusSeconds(GIGASECOND);
    }

    LocalDateTime getDateTime() {
	    return this.momentPlusGigasecond;
    }

}
