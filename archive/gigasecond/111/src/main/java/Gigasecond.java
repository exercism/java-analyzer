import java.time.*;

class Gigasecond {

    private LocalDateTime date;

    Gigasecond(LocalDate moment) {
    date =moment.atTime(0,0);
   }

    Gigasecond(LocalDateTime moment) {
    date = moment;
    }

    LocalDateTime getDateTime() {
        return date.plusSeconds(1000000000);
    }
}
