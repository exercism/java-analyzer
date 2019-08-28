import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private static final long gigasecond = 1000000000; 
    private LocalDateTime gigasecondTime;

    Gigasecond(LocalDate moment) {
        addGigasecond(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        addGigasecond(moment);
    }

    private void addGigasecond(LocalDateTime moment) {
        this.gigasecondTime = moment.plusSeconds(gigasecond);
    }

    LocalDateTime getDateTime() {
        return gigasecondTime;
    }

}
