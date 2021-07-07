import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

  private static final long GIGASECOND = 1_000_000_000;

  private LocalDateTime timestamp = null;

    Gigasecond(LocalDate moment) {
      this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
      this.timestamp = moment;
    }

    LocalDateTime getDateTime() {
      return this.timestamp.plusSeconds(Gigasecond.GIGASECOND);
    }

}
