import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDateTime bdayTime;

    Gigasecond(LocalDate birthDate) {
        this.bdayTime = birthDate.atTime(0, 0);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.bdayTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return bdayTime.plusSeconds(1_000_000_000);
    }

}
