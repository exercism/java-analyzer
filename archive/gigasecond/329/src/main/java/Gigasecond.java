import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private long timeToLive = (long) Math.pow(10, 9);
    private LocalDateTime dateTime;

    Gigasecond(LocalDate birthDate) {
        dateTime = LocalDateTime.of(birthDate.getYear(), birthDate.getMonth(), birthDate.getDayOfMonth(), 0, 0);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        dateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return dateTime.plusSeconds(timeToLive);
    }

}
