import java.time.*;

class Gigasecond {

    private LocalDate date = null;
    private LocalTime time = null;
    private static final long SECS_TO_ADD = 1000000000L;

    Gigasecond(LocalDate moment) {

        if (moment != null)
            date = moment;
    }

    Gigasecond(LocalDateTime moment) {

        if (moment != null)
        {
            date = moment.toLocalDate();
            time = moment.toLocalTime();
        }
    }

    LocalDateTime getDateTime() {

        if (time == null)
            time = LocalTime.of(0, 0, 0, 0);

        return LocalDateTime.of(date, time).plusSeconds(SECS_TO_ADD);
    }

}
