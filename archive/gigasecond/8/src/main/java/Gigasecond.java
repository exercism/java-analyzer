import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

class Gigasecond {

    private final LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = LocalDateTime.of(moment, LocalTime.MIN);
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return moment.plusSeconds(1000000000L);
        //return moment.plus(1000000000L, ChronoUnit.SECONDS);
        //return moment.plusSeconds((long)Math.pow(10.0,9.0));
    }

}
