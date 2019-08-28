import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    LocalDateTime endTime;

    Gigasecond(LocalDate birthDate) {
      this.endTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
      this.endTime = LocalDateTime.from(birthDateTime);
    }

    LocalDateTime getDateTime() {
      return this.endTime.plusSeconds(1000000000l);
    }
}
