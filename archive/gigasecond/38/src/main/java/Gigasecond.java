import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

	private long one_gigasecond = 1000000000;
	private LocalDateTime gigasecondDateTime;

    Gigasecond(LocalDate moment) {
		LocalDateTime momentDateTime = moment.atStartOfDay();
		gigasecondDateTime = momentDateTime.plusSeconds(one_gigasecond);
    }

    Gigasecond(LocalDateTime moment) {
		gigasecondDateTime = moment.plusSeconds(one_gigasecond);
    }

    LocalDateTime getDateTime() {
		return gigasecondDateTime;
    }

}
