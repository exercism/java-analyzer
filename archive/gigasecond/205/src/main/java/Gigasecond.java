import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime gigaTime;
    private static final long GIGASECOND = 1_000_000_000;

    Gigasecond(LocalDate moment) {
        gigaTime = moment.atStartOfDay().plusSeconds(GIGASECOND);
    }

    Gigasecond(LocalDateTime moment) {
        gigaTime = moment.plusSeconds(GIGASECOND);
    }

    LocalDateTime getDateTime() {
        return gigaTime;
    }

}
