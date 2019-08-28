import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    LocalDateTime gsDateTime;
    Gigasecond(LocalDate moment) {
        gsDateTime=LocalDateTime.of(moment, LocalTime.of(0, 0, 0));
       
    }

    Gigasecond(LocalDateTime moment) {
        gsDateTime=moment;
      
    }

    LocalDateTime getDateTime() {
        return gsDateTime.plusSeconds((long) Math.pow(10,9));
    }

}
