import java.time.LocalDate;
import java.time.LocalDateTime;


class Gigasecond {
	
	private final LocalDateTime date;
	private static final long GIGASECOND = 1_000_000_000L;
	
	
	Gigasecond(LocalDate date) {
		this(date.atStartOfDay());
    }

    Gigasecond(LocalDateTime date) {
    	this.date = date;
    }

    LocalDateTime getDateTime() {
    	return date.plusSeconds(GIGASECOND);
    	
    	
    }

  
}
