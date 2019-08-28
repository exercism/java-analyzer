import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

  int GIGASECOND = 1000000000;

  private LocalDateTime dateTime;

  private void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  Gigasecond(LocalDate moment) {
    this(moment.atStartOfDay());
  }

  Gigasecond(LocalDateTime moment) {
    setDateTime(moment.plus(GIGASECOND, ChronoUnit.SECONDS));
  }

  LocalDateTime getDateTime() {
    return dateTime;
  }
}
