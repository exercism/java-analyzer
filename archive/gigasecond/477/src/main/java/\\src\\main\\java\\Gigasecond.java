import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDateTime date;

    Gigasecond(LocalDate birthDate) {
        this.date = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.date = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return this.date.plusSeconds(1000000000);
    }

}
