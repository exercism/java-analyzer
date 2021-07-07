import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime time;

    Gigasecond(LocalDate birthDate) {
        this.time = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.time = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return time.plusSeconds(1000000000);
    }

}
