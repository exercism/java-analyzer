import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {
    private final int addedSeconds =1000000000;
    LocalDateTime constructedMoment;


    Gigasecond(LocalDate moment) {
        LocalTime time = LocalTime.of(0, 0, 0);
        constructedMoment = LocalDateTime.of(moment,time);
    }

    Gigasecond(LocalDateTime moment) {
        constructedMoment = moment;
    }

    LocalDateTime getDateTime() {
        return constructedMoment.plusSeconds(addedSeconds);
    }

}
