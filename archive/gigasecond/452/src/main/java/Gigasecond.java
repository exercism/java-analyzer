import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    private LocalDateTime birthDateTime;
    final private long GIGA = 1000000000;

    Gigasecond(LocalDate birthDate) {
        this.birthDateTime = LocalDateTime.of(birthDate, LocalTime.of(0, 0, 0));
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return this.birthDateTime.plusSeconds(this.GIGA);
    }
}
