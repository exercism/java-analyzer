import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.time.LocalDateTime.of;

class Gigasecond {

    private LocalDate     localDate;
    private LocalDateTime localDateTime;

    private static final long      GIGA_SEC           = 1_000_000_000L;
    private static final LocalTime LOCAL_TIME_DEFAULT = LocalTime.of(0, 0, 0);

    Gigasecond(LocalDate birthDate) {
        this.localDate = birthDate;
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.localDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return this.localDateTime == null ? of(this.localDate, LOCAL_TIME_DEFAULT).plusSeconds(GIGA_SEC)
                                          : localDateTime.plusSeconds(GIGA_SEC);
    }

}
