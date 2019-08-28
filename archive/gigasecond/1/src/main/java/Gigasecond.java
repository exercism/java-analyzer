import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond{
	private LocalDate gsLD;
	private LocalDateTime gsLDT;
	private LocalDateTime gs;

    Gigasecond(LocalDate moment) {
	this(moment.atTime(0,0));
    }

    Gigasecond(LocalDateTime moment) {
	gsLD = moment.toLocalDate();
	gsLDT = moment;
	gs = moment.plusSeconds(1000000000);
    }

    LocalDateTime getDateTime() {
	return gs;
    }
}
