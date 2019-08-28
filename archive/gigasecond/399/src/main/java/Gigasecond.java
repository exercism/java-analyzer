import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    LocalDateTime inLocalDateTime;

    Gigasecond(LocalDate birthDate) {
        inLocalDateTime = birthDate.atTime(0,0);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        inLocalDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return inLocalDateTime.plusSeconds(1_000_000_000);
    }

}
