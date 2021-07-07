import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

class Gigasecond {

    private LocalDateTime dateTime;
    private static final int GIGASECOND = 1000000000;

    Gigasecond(LocalDate moment) {
        long days = TimeUnit.SECONDS.toDays(GIGASECOND);

        final long DAYS_IN_SECONDS = TimeUnit.DAYS.toSeconds(days);

        int hours = (int) TimeUnit.SECONDS.toHours(GIGASECOND - DAYS_IN_SECONDS);

        final long HOURS_IN_SECONDS = TimeUnit.HOURS.toSeconds(hours);
        int minutes = (int) TimeUnit.SECONDS.toMinutes(GIGASECOND - DAYS_IN_SECONDS - HOURS_IN_SECONDS);

        final long MINUTES_IN_SECONDS = TimeUnit.MINUTES.toSeconds(minutes);
        int seconds = (int) TimeUnit.SECONDS.toSeconds(GIGASECOND - DAYS_IN_SECONDS - HOURS_IN_SECONDS - MINUTES_IN_SECONDS);

        this.dateTime = moment.plus(days, ChronoUnit.DAYS).atTime(hours, minutes, seconds);
    }

    Gigasecond(LocalDateTime moment) {
        this.dateTime = moment.plus(GIGASECOND, ChronoUnit.SECONDS);
    }

    LocalDateTime getDateTime() {
        return this.dateTime;
    }

}
