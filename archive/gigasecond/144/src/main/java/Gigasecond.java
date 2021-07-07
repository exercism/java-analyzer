import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final LocalDateTime finalDate;
    private static final long gigasecond = (long) Math.pow(10, 9);

    Gigasecond(LocalDate moment) {
        finalDate = addGigasecond(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        finalDate = addGigasecond(moment);
    }

    private LocalDateTime addGigasecond(LocalDateTime moment) {
        return moment.plusSeconds(gigasecond);
    }

    LocalDateTime getDateTime() {
        return finalDate;
    }

}
