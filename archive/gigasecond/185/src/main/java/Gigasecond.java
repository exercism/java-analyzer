import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private static long GIGASECOND = 1000000000;

    private LocalDateTime ldt;

    Gigasecond(LocalDate moment) {
      ldt = moment.atStartOfDay();
      ldt = ldt.plusSeconds(GIGASECOND);
    }

    Gigasecond(LocalDateTime moment) {
      ldt = moment.plusSeconds(GIGASECOND); 
    }

    LocalDateTime getDateTime() {
        return ldt;
    }

}
