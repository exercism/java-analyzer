import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    static final int GIGASECONDS = 1_000_000_000;
    private LocalDateTime newDateTime;


    Gigasecond(LocalDate birthDate) {
        this.newDateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.newDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return newDateTime.plusSeconds(GIGASECONDS);
    }

}
