import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {


    LocalDateTime birthDateTime;
    final static long GIGASECOND = 1000000000;


    Gigasecond(LocalDate birthDate) {
        birthDateTime = birthDate.atTime(0,0,0);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        LocalDateTime dateToLiveToReachGigasecond = birthDateTime.plusSeconds(GIGASECOND);
        return dateToLiveToReachGigasecond;
    }

}
