import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private static final long SECONDS_TO_ADD = (long) Math.pow(10, 9);
    private final LocalDateTime timeWithAddedSeconds;


    Gigasecond(final LocalDate birthDate) {
        this.timeWithAddedSeconds = birthDate.atStartOfDay().plusSeconds(SECONDS_TO_ADD);
    }

    Gigasecond(final LocalDateTime birthDateTime) {
        this.timeWithAddedSeconds = birthDateTime.plusSeconds(SECONDS_TO_ADD);
    }

    LocalDateTime getDateTime() {
        return timeWithAddedSeconds;
    }

}
