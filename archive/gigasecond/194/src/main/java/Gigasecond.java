import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime dateTime;

    Gigasecond(LocalDate birthDate) {
        dateTime = birthDate.atTime(0,0);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        dateTime = birthDateTime;
    }

    LocalDateTime getDate() {
        return dateTime.plusSeconds(1000000000);
    }

}
