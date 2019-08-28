import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;


class Gigasecond {
    private LocalDate date;
    private LocalDateTime dateTime;


    Gigasecond(LocalDate moment) {
        this.date = moment;
    }

    Gigasecond(LocalDateTime moment) {
        this.dateTime = moment;
    }

    LocalDateTime getDateTime() {
        long gigasecond = 1000000000;
        LocalDateTime d;

        if (date != null) {
            int year = date.getYear();
            Month month = date.getMonth();
            int day = date.getDayOfMonth();

            d = LocalDateTime.of(year, month, day, 0, 0);
        } else d = dateTime;

        return d.plusSeconds(gigasecond);
    }
}
