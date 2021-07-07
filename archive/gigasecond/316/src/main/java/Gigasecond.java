import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

class Gigasecond {

	LocalDate birthDate;

	LocalDateTime localDateTime;

    Gigasecond(LocalDate birthDate) {
    	this.birthDate = LocalDate.of(birthDate.getYear(), birthDate.getMonth(), birthDate.getDayOfMonth());
    }

    Gigasecond(LocalDateTime localDateTime) {
    	this.localDateTime = LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonth(), 
    			localDateTime.getDayOfMonth(), localDateTime.getHour(), localDateTime.getMinute(),
    			localDateTime.getSecond());
    }

    LocalDateTime getDateTime() {
    	LocalDateTime date = null;
    	if(birthDate != null) {
	    	Date d = new Date((long)(this.birthDate.toEpochDay() * 24 * 60 * 60 * 1000 + Math.pow(10, 9)*1000 - 60*60*1000));
	    	date = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    	}
    	else if (localDateTime != null) {
    		date = this.localDateTime.plusSeconds((long) Math.pow(10, 9));
    	}
       return date;
    }

}
