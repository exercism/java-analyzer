import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDateTime date;
    
    Gigasecond(LocalDate moment) {
        date = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        date = moment;
    }

    LocalDateTime getDateTime() {
        return date.plusSeconds(1000000000);
    }

}
