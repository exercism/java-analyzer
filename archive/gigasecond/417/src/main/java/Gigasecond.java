import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

	private LocalDate date;
	private LocalDateTime dateTime;

    Gigasecond(LocalDate birthDate) {
        this.date = birthDate;
        this.dateTime = null;
    }

    Gigasecond(LocalDateTime birthDateTime) {
    	this.date = null;
    	this.dateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
    	if (this.dateTime == null)
    		this.dateTime = this.date.atStartOfDay();
    	return (this.dateTime.plusSeconds(1000000000));
    }

}
