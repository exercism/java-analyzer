import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    private final static long GIGA_SECOND = 1_000_000_000;

    private final LocalDateTime baseMoment;

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        this.baseMoment = moment;
    }

    LocalDateTime getDateTime() {
        return baseMoment.plusSeconds(GIGA_SECOND);
    }

}
