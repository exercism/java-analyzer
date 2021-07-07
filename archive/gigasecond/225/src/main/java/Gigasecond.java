import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

  private static final long gigaSeconds = 1000000000;
  private static final LocalTime midnight = LocalTime.of(0, 0, 0);
  private final LocalDateTime gigaDateTime;

  Gigasecond(LocalDate moment) {
    gigaDateTime = LocalDateTime.of(moment, midnight).plusSeconds(gigaSeconds);
  }

  Gigasecond(LocalDateTime moment) {
    gigaDateTime = moment.plusSeconds(gigaSeconds);
  }

  LocalDateTime getDateTime() {
    return gigaDateTime;
  }

}
