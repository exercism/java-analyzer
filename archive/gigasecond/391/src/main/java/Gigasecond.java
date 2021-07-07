import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    private LocalDateTime dob;

    Gigasecond(LocalDate birthDate) {
        dob = birthDate.atStartOfDay().plus(1000000000, ChronoUnit.SECONDS);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        dob = birthDateTime.plus(1000000000, ChronoUnit.SECONDS);
    }

    LocalDateTime getDateTime() {
        return dob;
    }

}
