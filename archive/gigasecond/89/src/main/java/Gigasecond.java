import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime dateTime;
    private static final long gigaSecond = (long) Math.pow(10, 9);

    public Gigasecond(LocalDate date) {
        this.dateTime = date.atStartOfDay();
    }

    public Gigasecond(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    LocalDateTime getDateTime() {

        return dateTime.plusSeconds(gigaSecond);
    }

}
