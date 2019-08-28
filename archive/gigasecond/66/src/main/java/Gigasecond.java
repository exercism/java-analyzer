import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
   public static final Integer GIGASECOND=1000000000;
    private LocalDateTime moment;
    Gigasecond(LocalDate moment) {
          this(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime date) {
         date.getSecond(moment);
         getDateTime(date+GIGASECOND);
              }

    LocalDateTime getDateTime() {
return moment;
    }

}
