import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

class Gigasecond {

    private static final long GIGASECOND = 1000000000L;
    private final LocalDateTime birthDateTime;
    Gigasecond(LocalDate birthDate) {
        this.birthDateTime = LocalDateTime.of(birthDate, LocalTime.of(0, 0, 0));
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return LocalDateTime.ofEpochSecond(birthDateTime.toEpochSecond(ZoneOffset.UTC) + GIGASECOND, 0, ZoneOffset.UTC);
    }

}
