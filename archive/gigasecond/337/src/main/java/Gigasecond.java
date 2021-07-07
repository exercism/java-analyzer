import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final LocalDateTime birthDateTime;

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    Gigasecond(LocalDate birthDate) {
        this(birthDate.atTime(0,0,0));
    }

    LocalDateTime getDateTime() {
        return this.birthDateTime.plusSeconds((long)Math.pow(10,9));
    }

}
