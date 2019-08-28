import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

class Gigasecond {

    public static final int GIGA_SECOND = 1_000_000_000;
    public static final ZoneOffset OFFSET = ZoneOffset.UTC;
    private final LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
        birthDateTime = birthDate.atTime(0,0);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        long gigaDate = birthDateTime.toEpochSecond(OFFSET) + GIGA_SECOND;
        return LocalDateTime.ofEpochSecond(gigaDate, 0, OFFSET);
    }

}
