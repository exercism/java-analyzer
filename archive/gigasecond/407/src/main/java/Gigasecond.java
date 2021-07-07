import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    int millisec = 1000000000;

    private LocalDateTime dateTime;

    Gigasecond(LocalDate birthDate) {
        LocalDateTime d = birthDate.atStartOfDay();
        dateTime = d.plus(millisec, ChronoUnit.SECONDS);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        dateTime = birthDateTime.plus(millisec, ChronoUnit.SECONDS);
    }

    LocalDateTime getDateTime() {
        return dateTime;
    }

}
