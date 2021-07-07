import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime dateTime;
    private static final long TIME_LAPSE = (long)Math.pow(10,9);

    Gigasecond(LocalDate birthDate) {
        dateTime = birthDate.atStartOfDay().plusSeconds(TIME_LAPSE);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        dateTime = birthDateTime.plusSeconds(TIME_LAPSE);
    }

    LocalDateTime getDateTime() {
        return dateTime;
    }

}
