import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private static int GIGASECOND = 1000000000;
    private LocalDateTime givenDate;

    Gigasecond(LocalDate moment) {
        if (moment != null){
            givenDate = moment.atStartOfDay();
        }
    }

    Gigasecond(LocalDateTime moment) {
        if (moment != null){
            givenDate = moment;
        }
    }

    LocalDateTime getDateTime() {
        return givenDate.plusSeconds(GIGASECOND);
    }

}
