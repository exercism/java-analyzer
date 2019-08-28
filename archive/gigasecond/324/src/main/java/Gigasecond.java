import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime birthDate;

    Gigasecond(LocalDate birthDate) {
        this.birthDate = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDate = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return this.birthDate.plusSeconds((long) Math.pow(10, 9));
    }

}
