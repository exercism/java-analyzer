import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

class Gigasecond {

    LocalDateTime date;

    Gigasecond(LocalDate moment) {
       
        LocalDateTime temp = LocalDateTime.of(moment, LocalTime.MIDNIGHT);
        
        date = temp.plusSeconds(1000000000);

    }

    Gigasecond(LocalDateTime moment) {
        
        date = moment.plusSeconds(1000000000);
    }

    LocalDateTime getDateTime() {
        
        return date;
    }

}
