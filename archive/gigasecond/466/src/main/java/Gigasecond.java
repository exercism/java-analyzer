import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
	private static final long gigasecond = 1_000_000_000;
	private LocalDateTime gigasecondDateTime;

    Gigasecond(LocalDate birthDate) {
        this(LocalDateTime.of(birthDate, LocalTime.of(0, 0, 0, 0)));
    }

    Gigasecond(LocalDateTime birthDateTime) {
        gigasecondDateTime = birthDateTime.plusSeconds(gigasecond);
    }

    LocalDateTime getDateTime() {
        return gigasecondDateTime;
    }

}
