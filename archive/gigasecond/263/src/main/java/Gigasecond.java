import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

	public static long seconds = (long)Math.pow(10, 9);
	public LocalDateTime moment;

    public Gigasecond(LocalDate momentDate) {
        this.moment = momentDate.atStartOfDay();
    }

    public Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    public LocalDateTime getDateTime() {
        return moment.plusSeconds(seconds);
    }

}