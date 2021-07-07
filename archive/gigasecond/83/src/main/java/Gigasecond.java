import java.time.*;

class Gigasecond {
    private final int GIGASECOND = (int) Math.pow(10, 9);
    private final LocalDateTime dateTime;

    Gigasecond(final LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(final LocalDateTime moment) {
        this.dateTime = moment.plusSeconds(GIGASECOND);
    }

    LocalDateTime getDateTime() {
        return this.dateTime;
    }

}
