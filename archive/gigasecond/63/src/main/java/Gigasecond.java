import java.time.*;

class Gigasecond {

    private static final long GIGA = 1000000000;

    private LocalDateTime localDateTime;

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        localDateTime = moment;
    }

    LocalDateTime getDateTime() {
        return localDateTime.plusSeconds(GIGA);
    }

}
