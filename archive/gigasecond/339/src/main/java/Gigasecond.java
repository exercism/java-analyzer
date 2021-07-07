import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {
    private LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
      this.birthDateTime = birthDate.atTime(LocalTime.of(0, 0));
    }

    Gigasecond(LocalDateTime birthDateTime) {
      this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
      return this.birthDateTime.plusSeconds(1000000000);
    }
}
