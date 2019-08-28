import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
  private LocalDateTime birthDateTime;
  Gigasecond(LocalDate birthDate) {
    birthDateTime = birthDate.atStartOfDay();
  }

  Gigasecond(LocalDateTime birthDateTime) {
    this.birthDateTime = birthDateTime;
  }

  LocalDateTime getDateTime() {
    return birthDateTime.plusSeconds(1000000000);
  }

}
