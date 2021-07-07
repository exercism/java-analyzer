import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private static final int ONE_GIGASECOND = 1000000000;
    private LocalDateTime birthday;

    Gigasecond(LocalDate birthDate) {
        this.birthday = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthday = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return addSecondsTo(this.birthday, ONE_GIGASECOND);
    }

    private LocalDateTime addSecondsTo(LocalDateTime dateTime, int secondsToAdd) {
        return dateTime.plusSeconds(secondsToAdd);
    }
}
