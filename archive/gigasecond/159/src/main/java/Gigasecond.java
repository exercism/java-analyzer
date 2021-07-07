import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

  static final long giga = 1_000_000_000;
  private LocalDateTime moment;
  private LocalDateTime momentAfterGigasecond;

  Gigasecond(LocalDate moment) {
    this(moment.atStartOfDay());
  }

  Gigasecond(LocalDateTime moment) {
    this.moment = moment;
    this.momentAfterGigasecond = this.moment.plusSeconds(giga);
  }

  LocalDateTime getDateTime() {
    return momentAfterGigasecond;
  }
}
