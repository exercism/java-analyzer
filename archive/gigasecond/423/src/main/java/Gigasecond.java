import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime gigaSecondDateTime;

    Gigasecond(LocalDate birthDate) {
        gigaSecondDateTime = birthDate.atStartOfDay().plusSeconds(1000000000);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        gigaSecondDateTime = birthDateTime.plusSeconds(1000000000);
    }

    LocalDateTime getDateTime() {
        return gigaSecondDateTime;
    }

}
