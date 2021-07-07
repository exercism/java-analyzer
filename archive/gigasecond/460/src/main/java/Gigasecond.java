import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

class Gigasecond {

    private final LocalDateTime birthDateTime;
    Gigasecond(LocalDate birthDate) {
        this.birthDateTime = LocalDateTime.of(birthDate,LocalTime.MIN);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        long seconds = 1000000000;
        return this.birthDateTime.plusSeconds(seconds);
    }

}
