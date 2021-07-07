import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.LocalTime.MIDNIGHT;

class Gigasecond {

    LocalDateTime birth;
    static long GIGASECOND = 1_000_000_000L;

    Gigasecond(LocalDate birthDate) {
        birth = LocalDateTime.of(birthDate, MIDNIGHT);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        birth = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return birth.plusSeconds(GIGASECOND);
    }
}
