import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

class Gigasecond {

	private LocalDateTime baseTime;
	
    Gigasecond(LocalDate moment) {
        baseTime = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        baseTime = moment;
    }

    LocalDateTime getDateTime() {
        return baseTime.plusSeconds(1000000000);
    }

}
