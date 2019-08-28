import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
private static LocalDateTime momentBefore;
    Gigasecond(LocalDate moment) {
        this.momentBefore = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.momentBefore = moment;
    }

    LocalDateTime getDateTime() {
     
      return this.momentBefore.plusSeconds(1000000000);
    }

}
