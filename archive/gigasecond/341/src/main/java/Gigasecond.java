import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
	private LocalDateTime ldt;

    Gigasecond(LocalDate birthDate) {
		ldt=birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        ldt=birthDateTime;
    }

    LocalDateTime getDateTime() {
        return ldt.plusSeconds((long) Math.pow(10, 9));
    }

}
