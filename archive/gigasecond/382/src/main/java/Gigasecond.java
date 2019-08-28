import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

class Gigasecond {

	private static final Duration GIGASECOND = Duration.ofSeconds(BigInteger.TEN.pow(9).longValue());
	private final LocalDateTime birthDateTime;

	Gigasecond(LocalDate birthDate) {
        this(LocalDateTime.of(birthDate, LocalTime.MIN));
    }

    Gigasecond(LocalDateTime birthDateTime) {
    	this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
    	return this.birthDateTime.plus(GIGASECOND);
    }
}
