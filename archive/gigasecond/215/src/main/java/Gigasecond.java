import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
  static final long GIGASECONDS = (long) Math.pow(10, 9);
  private LocalDateTime aMoment;

  Gigasecond(LocalDate moment) {
    this(moment.atStartOfDay());
  }

  Gigasecond(LocalDateTime moment) {
    aMoment = moment;
  }

  LocalDateTime getDateTime() {
    return aMoment.plusSeconds(GIGASECONDS);
  }

}
