import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
	
	private LocalDateTime livedGigaDateTime;
	private long gigaSecond = (long) Math.pow(10, 9);

    Gigasecond(LocalDate moment) {
        livedGigaDateTime = moment.atStartOfDay().plusSeconds(gigaSecond);
    }

    Gigasecond(LocalDateTime moment) {
        livedGigaDateTime = moment.plusSeconds(gigaSecond);
    }

    LocalDateTime getDateTime() {
        return livedGigaDateTime;
    }

}
