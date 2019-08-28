import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {
    private LocalDateTime GigaTime;

    Gigasecond(LocalDate moment) {
        GigaTime = moment.atStartOfDay();
        GigaTime = GigaTime.plus(1000000000, ChronoUnit.SECONDS);
        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");

    }

    Gigasecond(LocalDateTime moment) {
        GigaTime = moment.plus(1000000000, ChronoUnit.SECONDS);
        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    LocalDateTime getDateTime() {
        return GigaTime;
        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}
