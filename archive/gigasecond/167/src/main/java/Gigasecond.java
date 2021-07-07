import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDateTime moment;
    private static final long gigaSeconds = 1000000000;

    Gigasecond(LocalDate moment) {
        if(moment == null) throw new IllegalArgumentException("The given moment cannot be empty.");
        this.moment = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        if(moment == null) throw new IllegalArgumentException("The given moment cannot be empty.");
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return moment.plusSeconds(gigaSeconds);
    }

}
