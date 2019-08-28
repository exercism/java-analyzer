
import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

	LocalDateTime ldatetime;
	LocalDateTime resulttime;

    Gigasecond(LocalDate moment) {
     	int year = moment.getYear();
    	int month = moment.getMonthValue();
    	int day = moment.getDayOfMonth();
    	int hh = 0 ;
    	int mm = 0 ;
    	int ss = 0 ;
    	ldatetime = LocalDateTime.of(year, month, day, hh, mm, ss); 
    }
    
    Gigasecond(LocalDateTime moment) {
    	int year = moment.getYear();
    	int month = moment.getMonthValue();
    	int day = moment.getDayOfMonth();
    	int hh = moment.getHour();
    	int mm = moment.getMinute();
    	int ss = moment.getSecond();
    	ldatetime = LocalDateTime.of(year, month, day, hh, mm, ss); 
    }
     
    LocalDateTime getDateTime() {
    	resulttime = ldatetime.plusSeconds(1_000_000_000) ;
    	return resulttime;
    }

}
