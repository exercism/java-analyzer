import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    private LocalDateTime dateTime;

    Gigasecond(LocalDate birthDate) {
        this.dateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.dateTime = birthDateTime;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime.plusSeconds(1000000000);
    }

}
