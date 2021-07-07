import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDateTime datePlusGigaSeconds;
    private final static long gigaSeconds = 1000000000;

    Gigasecond(LocalDate birthDate) {
        this.datePlusGigaSeconds = birthDate.atStartOfDay().plusSeconds(gigaSeconds);

    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.datePlusGigaSeconds = birthDateTime.plusSeconds(gigaSeconds);
    }

    LocalDateTime getDateTime() {
        return this.datePlusGigaSeconds;
    }

}
