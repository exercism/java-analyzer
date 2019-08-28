import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;

class Gigasecond {
    private final LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
        this.birthDateTime = birthDate.atTime(0,0,0);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {

        return birthDateTime.plusSeconds(1000000000);
    }

}
