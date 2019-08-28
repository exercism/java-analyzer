import java.time.*;

class Gigasecond {

    private LocalDateTime localDateTime;
    private final Duration gigaSecond = Duration.ofSeconds(1_000_000_000);

    Gigasecond(LocalDate moment) {
        this.localDateTime = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.localDateTime = moment;
    }

    LocalDateTime getDateTime() {
        return localDateTime.plus(gigaSecond);
    }

}
