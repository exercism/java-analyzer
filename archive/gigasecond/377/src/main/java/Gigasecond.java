import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    private long gigasecond = (long) Math.pow(10, 9);
    private LocalDateTime date;

    Gigasecond(LocalDate birthDate) {
        this.date = LocalDateTime.of(birthDate, LocalTime.MIDNIGHT).plusSeconds(this.gigasecond);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.date = birthDateTime.plusSeconds(gigasecond);
    }

    LocalDateTime getDateTime() {
        return this.date;
    }

}
