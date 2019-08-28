import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

  private LocalDateTime bDateTime;
  private final int NINE = 1_000_000_000;

  Gigasecond(LocalDate birthDate) {
    this.bDateTime = birthDate.atStartOfDay();
  }

  Gigasecond(LocalDateTime birthDateTime) {
    this.bDateTime = birthDateTime;
  }

  LocalDateTime getDateTime() {
    return this.bDateTime.plusSeconds(NINE);
  }

}
