import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Gigasecond {
  private static final int ONE_BILLION = 1000000000;

  private LocalDateTime date;

  public Gigasecond(LocalDate startDate) {
    this.date = startDate.atStartOfDay();
  }

  public Gigasecond(LocalDateTime startTime) {
    this.date = startTime;
  }

  public LocalDateTime getDateTime() {
    return date.plus(ONE_BILLION, ChronoUnit.SECONDS);
  }
}
