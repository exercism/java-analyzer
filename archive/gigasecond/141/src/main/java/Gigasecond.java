import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

  LocalDateTime moment;
  boolean calculated = false;

  Gigasecond(LocalDate moment) {
    this.moment = moment.atStartOfDay();
  }

  Gigasecond(LocalDateTime moment) {
      this.moment = moment;
  }

  LocalDateTime getDateTime() {
    if (!calculated) {
      addSeconds(1000000000);
      calculated = true;
    }
    return moment;
  }

  void addSeconds(int seconds) {
    this.moment =  moment.plusSeconds(seconds);
  }

}
