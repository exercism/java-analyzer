import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
	private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
    	// Create a LocalDateTime object instead of only LocalDate with midnight as the starting point.
    	// The tests require a LocalDateTime object and the plusSeconds function does not work with only a LocalDate object
        this.moment = LocalDateTime.of(moment.getYear(), moment.getMonth(), moment.getDayOfMonth(), 0, 0, 0);
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
    	// Add a Gigasecond to the moment.
        this.moment = moment.plusSeconds(1000000000);
        return this.moment;
    }

}
