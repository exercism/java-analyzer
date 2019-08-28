import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    private final LocalDate localDate;
    private LocalTime defaultLocalTime = LocalTime.of(0, 0, 0);
    private LocalTime specificLocalTime;

    Gigasecond(LocalDate moment) {
        this.localDate = moment;
    }

    Gigasecond(LocalDate moment, int hour, int minute, int second) {
        this.localDate = moment;
        this.specificLocalTime = LocalTime.of(hour, minute, second);
    }

    Gigasecond(LocalDateTime moment) {
        this.localDate = moment.toLocalDate();
        this.specificLocalTime = moment.toLocalTime();
    }

    LocalDateTime getDateTime() {
        return LocalDateTime.of(
                this.localDate,
                this.specificLocalTime != null ? this.specificLocalTime : this.defaultLocalTime
        ).plusSeconds(1000000000);
    }

    LocalTime createLocalTime(int hour, int minute, int second) {
        return LocalTime.of(hour, minute, second);
    }

}
