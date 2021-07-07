import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    LocalDateTime momentplus;


    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        int gig = 1000000000;
        this.momentplus = moment.plus(gig, ChronoUnit.SECONDS);;
    }

    LocalDateTime getDateTime() {
        return this.momentplus;
    }

}
