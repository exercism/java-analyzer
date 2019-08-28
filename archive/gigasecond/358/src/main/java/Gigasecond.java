import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final static Duration GIGA_SEC = Duration.ofSeconds(1000000000L);
    private LocalDateTime birthDatePlusGigaSec;

    Gigasecond(LocalDate birthDate) {
        birthDatePlusGigaSec = birthDate.atStartOfDay().plus(GIGA_SEC);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        birthDatePlusGigaSec = birthDateTime.plus(GIGA_SEC);
    }

    LocalDateTime getDateTime() {
        return birthDatePlusGigaSec;
    }

}
