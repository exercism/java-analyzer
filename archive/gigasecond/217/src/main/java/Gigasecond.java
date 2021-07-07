import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    private LocalDateTime localDateTime;

    Gigasecond(LocalDate moment) {
        LocalTime time = LocalTime.of(0, 0, 0);
        this.localDateTime = LocalDateTime.of(moment, time);
        addGigaSecond();
    }

    Gigasecond(LocalDateTime moment) {
        this.localDateTime = moment;
        addGigaSecond();
    }

    LocalDateTime getDateTime() {
        return localDateTime;
    }

    private void addGigaSecond() {
        this.localDateTime = localDateTime.plus(1000000000, ChronoUnit.SECONDS);
    }
}
