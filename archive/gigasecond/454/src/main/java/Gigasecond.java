import java.time.LocalDate;
import java.time.LocalDateTime;
import java.lang.Math;


class Gigasecond {
    private static final int GIGA_SECONDS = (int)Math.pow(10, 9);

    private LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {

        this.birthDateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return birthDateTime.plusSeconds(GIGA_SECONDS);
    }

}
