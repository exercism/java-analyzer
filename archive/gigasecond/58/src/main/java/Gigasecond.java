import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.*;
class Gigasecond {
    //DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    
    String time ;
    long s = 1000000000l;
    Gigasecond(LocalDate moment) {
        // throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        time = moment.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    Gigasecond(LocalDateTime moment) {
        // throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        time = moment.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    LocalDateTime getDateTime() {
        // throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
       
        
        LocalDateTime t = LocalDateTime.parse(time);
       
        
        
        return t.plusSeconds(s);
       
    }
}
