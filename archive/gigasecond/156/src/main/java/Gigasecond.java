import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    LocalDateTime momemtAfterGigaSecond;
    Integer gigaSecond = 1000000000;

    Gigasecond(LocalDate moment) {
        momemtAfterGigaSecond = moment.atStartOfDay().plusSeconds(gigaSecond);
    }

    Gigasecond(LocalDateTime moment) {
        momemtAfterGigaSecond = moment.plusSeconds(gigaSecond);
    }

    LocalDateTime getDateTime() {
        return momemtAfterGigaSecond;
    }

}
