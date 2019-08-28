import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

  private final int oneGig = 1000000000;
  LocalDateTime ldt;

  Gigasecond(LocalDate moment) {
    ldt = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
      ldt = moment;
    }

    LocalDateTime getDateTime() {
      return ldt.plusSeconds(oneGig);
    }

}
