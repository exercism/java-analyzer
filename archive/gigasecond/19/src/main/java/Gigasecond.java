import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDateTime result;

    Gigasecond(LocalDate moment) {
        result = moment.atStartOfDay().plusSeconds(1_000_000_000);
    }

    Gigasecond(LocalDateTime moment) {
        result = moment.plusSeconds(1_000_000_000);
    }

    LocalDateTime getDateTime() {
        return result;
    }

}
