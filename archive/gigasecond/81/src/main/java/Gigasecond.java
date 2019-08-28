import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    
    private LocalDateTime moment;
    
    private static final int GIGASECOND = (int)Math.pow(10.0,9.0);
    
	Gigasecond(LocalDate moment) {
        this.moment = moment.atStartOfDay();
		this.moment = calculateDateTime();
    }

	Gigasecond(LocalDateTime moment) {
        this.moment = moment;
		this.moment = calculateDateTime();
    }
	
	private LocalDateTime calculateDateTime() {
		LocalDateTime tmpMoment = moment.plusSeconds(GIGASECOND);
		return tmpMoment;
	}
	
	LocalDateTime getDateTime() {
        return moment;
    }

}
