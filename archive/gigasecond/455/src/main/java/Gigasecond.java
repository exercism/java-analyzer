import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private static final long gigasecond = 1000000000;

    private final LocalDateTime dateTime;

    Gigasecond(LocalDate birthDate) {
        dateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        dateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return appendGigasecondTo(dateTime);
    }

    private LocalDateTime appendGigasecondTo(LocalDateTime dateTime) {
        return dateTime.plusSeconds(gigasecond);
    }

}
