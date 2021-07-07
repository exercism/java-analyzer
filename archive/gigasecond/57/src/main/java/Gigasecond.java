import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDateTime time;

    Gigasecond(LocalDate moment) {
        int year = moment.getYear();
        int mouth = moment.getMonthValue();
        int date = moment.getDayOfMonth();
        time = LocalDateTime.of(year, mouth, date, 0, 0, 0);
    }

    Gigasecond(LocalDateTime moment) {
        time = moment;
    }

    LocalDateTime getDateTime() {
        return time.plusSeconds(1000000000);
    }

}
