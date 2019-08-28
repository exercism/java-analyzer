import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

class Gigasecond {
	private static final long A_GIGASECOND = (long)Math.pow(10,9);
	private LocalDateTime birthDateTime;


    Gigasecond(LocalDate birthDate) {
    	this.birthDateTime = LocalDateTime.of(birthDate, LocalTime.MIN);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return birthDateTime.plus(A_GIGASECOND, ChronoUnit.SECONDS);
    }

}
