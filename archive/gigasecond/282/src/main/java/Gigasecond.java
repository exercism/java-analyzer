import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
  private LocalDateTime date;

  Gigasecond(LocalDate birthDate) {
    this(birthDate.atStartOfDay());
  }

  Gigasecond(LocalDateTime birthDateTime) {
    date = birthDateTime.plusSeconds((long) Math.pow(10, 9));
  }

  LocalDateTime getDateTime() { 
	  return date;
  }
}