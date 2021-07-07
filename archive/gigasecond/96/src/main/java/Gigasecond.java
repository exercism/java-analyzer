import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDateTime dateAfterGigaSecond;

    Gigasecond(LocalDate moment) {
        LocalDateTime converted = moment.atStartOfDay();
        dateAfterGigaSecond = converted.plusSeconds(1000000000);
    }

    Gigasecond(LocalDateTime moment) {
        dateAfterGigaSecond = moment.plusSeconds(1000000000);
    }

    LocalDateTime getDateTime() {
        return dateAfterGigaSecond;
    }

}
