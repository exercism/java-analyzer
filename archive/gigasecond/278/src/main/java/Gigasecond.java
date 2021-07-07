import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    LocalDateTime localDateTime;

    Gigasecond(LocalDate birthDate) {
        this.localDateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.localDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return this.localDateTime.plusSeconds((long) Math.pow(10,9));
    }

}
