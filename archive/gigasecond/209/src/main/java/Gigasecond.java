import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    private static final int GIGASECOND = 1_000_000_000;

    LocalDateTime dataTime;

    Gigasecond(LocalDate moment) {
        this.dataTime = moment.atStartOfDay().plusSeconds(GIGASECOND);
    }

    Gigasecond(LocalDateTime moment) {
        this.dataTime = moment.plusSeconds(GIGASECOND);
    }

    LocalDateTime getDateTime() {
        return this.dataTime;
    }

}
