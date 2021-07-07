import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {
    private LocalDateTime result_;

    Gigasecond(LocalDate birthDate) {
        LocalDateTime bdt = LocalDateTime.of(birthDate, LocalTime.of(0, 0));
        result_ = bdt.plus(1_000_000_000, ChronoUnit.SECONDS);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        result_ = birthDateTime.plus(1_000_000_000, ChronoUnit.SECONDS);
    }

    LocalDateTime getDateTime() {
        return result_;
    }

}
