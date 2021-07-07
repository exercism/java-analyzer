import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDate moment;
    private LocalDateTime localDateTime;

    Gigasecond(LocalDate moment) {
        this.moment = moment;
    }

    Gigasecond(LocalDateTime moment) {
        this.localDateTime = moment;
    }

    LocalDateTime getDateTime() {

        int gigaSecond = 1000000000;
        LocalDateTime ldt;

        if (moment != null) {
            ldt = moment.atStartOfDay().plusSeconds(gigaSecond);
        } else ldt = localDateTime.plusSeconds(gigaSecond);

        return ldt;
    }

}
