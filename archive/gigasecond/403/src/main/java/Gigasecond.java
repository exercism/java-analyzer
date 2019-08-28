import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    LocalDateTime date;

    Gigasecond(LocalDate birthDate) {
        this.date = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.date = birthDateTime;
    }

    LocalDateTime getDateTime() {
        long gigasecond = 1000000000;
        return this.date.plusSeconds(gigasecond);

    }

}
