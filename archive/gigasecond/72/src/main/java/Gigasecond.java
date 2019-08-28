import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
	
	private Duration gigasecondOfTime = Duration.ofSeconds(1000000000);
	private LocalDateTime moment;
	
    public Gigasecond(LocalDate moment) {
    	this(moment.atStartOfDay());
    }

    public Gigasecond(LocalDateTime moment) {
    	this.moment = moment;
    }

    public LocalDateTime getDateTime() {
        return moment.plus(gigasecondOfTime);
    }

}
