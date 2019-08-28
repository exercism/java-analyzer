import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    private static LocalDate ldMoment;
    private static LocalDateTime ldtMoment;
    private static final long GIGASECOND = 1000000000;

    Gigasecond(LocalDate moment) {
        ldMoment = moment;
        ldtMoment = null;
    }

    Gigasecond(LocalDateTime moment) {
        ldtMoment = moment;
    }

    LocalDateTime getDateTime() {
        if(ldtMoment == null) {
            LocalTime localTime = LocalTime.of(0, 0, 0, 0);
            ldtMoment = LocalDateTime.of(this.ldMoment, localTime);
        }
        ldtMoment = this.ldtMoment.plusSeconds(GIGASECOND);
        return ldtMoment;
    }

}
