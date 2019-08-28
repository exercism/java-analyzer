import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {


    private LocalDateTime birthDateTime ;


    Gigasecond(LocalDate birthDate) {
        this.birthDateTime = birthDate.atTime(0, 0);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime  ;
    }

    LocalDateTime getDateTime() {
        return birthDateTime.plus(1000000000,ChronoUnit.SECONDS);
    }

}
