import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime dateTime;
    private static final long seconds = 1000000000;

    Gigasecond(LocalDate birthDate) {
        if (birthDate == null) throw new IllegalArgumentException("The birthDate cannot be empty.");
        this.dateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        if (birthDateTime == null) throw new IllegalArgumentException("The birthDateTime cannot be empty.");
        this.dateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return this.dateTime.plusSeconds(seconds);
    }

}
