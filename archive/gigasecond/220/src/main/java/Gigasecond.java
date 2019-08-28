import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
class Gigasecond {

    private  LocalDate localDate;
     private  LocalDateTime localDateTime;
     
     Gigasecond(LocalDate moment) {
        this.localDate=moment;
    }

    Gigasecond(LocalDateTime moment) {
        this.localDateTime=moment;
    }

    LocalDateTime getDateTime() {
        LocalDateTime date=null;
        if (localDate!=null) {
           LocalDate sum=this.localDate;
          LocalTime specificTime = LocalTime.of(0,0,0);
         LocalDateTime b=LocalDateTime.of(sum, specificTime);
         date = b.plusSeconds(1000000000);
        } else {
            
            LocalDateTime a =this.localDateTime;
           date = a.plusSeconds(1000000000);
        }
       
        
        return date;
    }

}
