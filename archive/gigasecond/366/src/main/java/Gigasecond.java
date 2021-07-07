import java.time.LocalDate;
import java.time.LocalDateTime;


class Gigasecond {

    private LocalDateTime birthTime;

    Gigasecond(LocalDate birthDate) {
        // Converts to LocalDateTime and adds seconds
        this.birthTime = birthDate.atStartOfDay().plusSeconds((long)Math.pow(10,9));
    }

    Gigasecond(LocalDateTime birthDateTime) {
        // Adds seconds
        this.birthTime = birthDateTime.plusSeconds((long)Math.pow(10,9));
    }

    LocalDateTime getDateTime() {
        return this.birthTime;
    }


}
