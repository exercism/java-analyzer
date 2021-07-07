import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

  private static long GIGA_SECOND = 1_000_000_000L;
  private LocalDateTime time;

  Gigasecond(LocalDate moment) {
    time = moment.atStartOfDay();
  }

  Gigasecond(LocalDateTime moment) {
    time = moment;
  }

  LocalDateTime getDateTime() {
    return time.plusSeconds(GIGA_SECOND);
  }

}
