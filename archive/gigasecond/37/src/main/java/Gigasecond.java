import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

	private static final int GIGASECOND = 1_000_000_000;
	private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return this.moment.plusSeconds(this.GIGASECOND);
    }

}
