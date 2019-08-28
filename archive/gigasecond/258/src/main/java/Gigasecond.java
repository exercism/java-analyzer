import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    
    public static final long GIGASECOND = (long) Math.pow(10, 9);
    private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return moment.plusSeconds(GIGASECOND);
    }

}
