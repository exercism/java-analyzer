import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
  private final LocalDateTime gigadate;

  Gigasecond(LocalDate birthDate) {
    this(birthDate.atStartOfDay());
  }

  Gigasecond(LocalDateTime birthDateTime) {
    gigadate = birthDateTime.plusSeconds(1_000_000_000);
  }

  LocalDateTime getDateTime() { return gigadate; }
}