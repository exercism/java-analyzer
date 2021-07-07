import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime birthMoment;

    Gigasecond(LocalDate birthDate) {
        birthMoment = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        birthMoment = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return birthMoment.plusSeconds(1000000000);
    }

}
