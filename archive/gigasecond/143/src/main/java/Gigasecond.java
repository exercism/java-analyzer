import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    private LocalDateTime now;
    private LocalDateTime after;
    private static int dayTime = 60 * 60 * 24;

    Gigasecond(LocalDate moment) {
        this.now = LocalDateTime.of(moment, LocalTime.of(0, 0, 0));
    }

    Gigasecond(LocalDateTime moment) {
        this.now = moment;
    }

    LocalDateTime getDateTime() {
        if (after == null) {
            int left = new Double(Math.pow(10, 9)).intValue();
            while (left >= dayTime) {
                now = now.plusDays(1);
                left -= dayTime;
            }

            now = now.plus(left, ChronoUnit.SECONDS);
            after = now;
        }

        return after;
    }

}
