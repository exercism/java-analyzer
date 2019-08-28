import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {
	
	private static final long OFFSET = 1_000_000_000L;
	
	private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
		this.moment = addOffset(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
		this.moment = addOffset(moment);
    }

    LocalDateTime getDateTime() {
        return moment;
    }
	
	private static LocalDateTime addOffset(LocalDateTime moment) {
		return moment.plus(OFFSET, ChronoUnit.SECONDS);
	}

}
