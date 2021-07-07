import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalUnit;

class Gigasecond {
  private long GIGASECOND = 1000000000;
  private LocalDateTime ldt;

  Gigasecond(LocalDate birthDate) {
    ldt = birthDate.atStartOfDay();
  }

  Gigasecond(LocalDateTime birthDateTime) {
    ldt = birthDateTime;
  }

  LocalDateTime getDateTime() {
    return ldt.plusSeconds(GIGASECOND);
  }
}
