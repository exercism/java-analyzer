import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime birthDate;

    Gigasecond(LocalDate moment) {
        this.birthDate = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.birthDate = moment;
    }

    LocalDateTime getDateTime() {
        return this.birthDate.plusSeconds(1_000_000_000);
    }

}
