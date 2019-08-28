import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDate birthDate;
    private LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        // 10^9 = 1_000_000_000
        LocalDateTime dateTime;

        if (birthDateTime == null) {
            birthDateTime = birthDate.atTime(0,0,0);
        }
        return birthDateTime.plusSeconds(1_000_000_000);
    }

}
