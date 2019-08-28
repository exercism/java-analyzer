import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final LocalDateTime dateTime;

    Gigasecond(LocalDate birthDate) {
        this(birthDate.atStartOfDay());
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.dateTime = birthDateTime.plusSeconds(1000000000);
    }

    LocalDateTime getDateTime() {
        return dateTime;
    }

}
