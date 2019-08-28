import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDateTime dateTime;

    Gigasecond(LocalDate moment) {
        dateTime = birthDate.atTime(0,0);
    }

    Gigasecond(LocalDateTime moment) {
        dateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return dateTime.plusSeconds(1000000000);
    }

}
