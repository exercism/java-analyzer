import java.util.Date;
import java.time.*;

class Gigasecond {
	LocalDate birthDate;
	LocalDateTime birthDateTime;
	Gigasecond(LocalDate birthDate) {
    	this.birthDate=birthDate;
        
    }

    Gigasecond(LocalDateTime birthDateTime) {
    	this.birthDateTime=birthDateTime;
       
    }

    LocalDateTime getDateTime() {
    	LocalDateTime result=LocalDateTime.now();
         if(birthDateTime!=null)
         result=birthDateTime.plusSeconds(1000000000);
        else if(birthDate!=null)
         result=(birthDate.atStartOfDay()).plusSeconds(1000000000);
        return result;
    }

}
