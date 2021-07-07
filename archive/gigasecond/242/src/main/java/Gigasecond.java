import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    public static final int ONE_BILLION_SECONDS = 1000000000;
    LocalDateTime livedForOneGigasecond;

    Gigasecond(LocalDate moment) {
        this.livedForOneGigasecond = moment.atStartOfDay().plusSeconds(ONE_BILLION_SECONDS);
    }

    Gigasecond(LocalDateTime moment) {
        LocalTime timeOfMoment = moment.toLocalTime();
        this.livedForOneGigasecond = moment.toLocalDate().atTime(timeOfMoment).plusSeconds(ONE_BILLION_SECONDS);
    }

    LocalDateTime getDateTime() {
        return livedForOneGigasecond;
    }

}
