import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private final long gigasecond = 1000000000;
    private LocalDateTime moment;


    Gigasecond(LocalDate moment) {
        this.moment = LocalDateTime.of(moment.getYear(), moment.getMonth(), moment.getDayOfMonth(), 0, 0);
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {

        return moment.plusSeconds(gigasecond);
    }

}
