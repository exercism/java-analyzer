import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

  private LocalDateTime birthDateTime;

  Gigasecond(LocalDateTime birthDateTime) {
    // A gigasecond is 10^9 seconds.
    this.birthDateTime = birthDateTime.plusSeconds((long) Math.pow(10, 9));
  }

  Gigasecond(LocalDate birthDate) {
    this(birthDate.atStartOfDay());
  }

  LocalDateTime getDateTime() {
    return this.birthDateTime;
  }

}
