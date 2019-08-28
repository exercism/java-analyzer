import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

  LocalDateTime gigasecondLater;

  Gigasecond(LocalDate moment) {
    this(moment.atStartOfDay());
  }

  Gigasecond(LocalDateTime moment) {
    gigasecondLater = moment.plusSeconds(1000000000);
  }

  LocalDateTime getDateTime() {
    return gigasecondLater;
  }
}
