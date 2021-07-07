import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
        if (birthDateTime == null && birthDate != null) {
            birthDateTime = LocalDateTime.of(birthDate, LocalTime.of(0, 0, 0));
        }
        return birthDateTime.plusSeconds(1_000_000_000);
    }

}
