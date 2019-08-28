import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    LocalDateTime ldt;

    Gigasecond(LocalDate birthDate) {
        this.ldt = LocalDateTime.of(birthDate, LocalTime.of(0,0));
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.ldt = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return ldt.plusSeconds((long) Math.pow(10, 9));
    }
}
