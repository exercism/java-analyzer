import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

	private LocalDateTime curDate;
	private static long GIGA_SECONDS = 1000000000;
	
    Gigasecond(LocalDate moment) {
    	curDate = LocalDateTime.of(moment,LocalTime.MIDNIGHT );
    }

    Gigasecond(LocalDateTime moment) {
    	curDate = moment;
    }

    LocalDateTime getDateTime() {
    	curDate = curDate.plusSeconds(GIGA_SECONDS);
    	return curDate;
    }

}
