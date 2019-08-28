import java.time.*;

class Gigasecond {

  Gigasecond(LocalDate moment) {
    this.moment = LocalDateTime.of(moment, LocalTime.MIDNIGHT);
  }
  Gigasecond(LocalDateTime moment) {
    this.moment = moment;
  }

  LocalDateTime getDateTime() {
    return moment.plus(Duration.ofSeconds(1_000_000_000));
  }

  LocalDateTime moment;

}
