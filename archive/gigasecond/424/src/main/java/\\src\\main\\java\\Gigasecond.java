import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

class Gigasecond {
    private LocalDateTime birthday;

    Gigasecond(LocalDate birthDate) {
        // converting the LocalDate to LocalDateTime by setting the remaining fields to midnight that day
        birthday = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        birthday = birthDateTime;
    }

    LocalDateTime getDateTime() {
        // variable to avoid magic numbers in code
        long gigaSecond = (long) 1e9;
        return birthday.plus(gigaSecond, ChronoUnit.SECONDS);
    }

}
