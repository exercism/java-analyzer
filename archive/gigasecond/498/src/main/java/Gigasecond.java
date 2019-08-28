import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    private LocalDateTime localDateTime;

    Gigasecond(LocalDate birthDate) {
        localDateTime = LocalDateTime.of(birthDate, LocalTime.MIN).plusSeconds(1000000000);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        localDateTime = birthDateTime.plusSeconds(1000000000);
    }

    LocalDateTime getDateTime() {
        return localDateTime;
    }
}
