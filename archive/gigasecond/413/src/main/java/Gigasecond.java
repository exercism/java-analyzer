import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
class Gigasecond {
	LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
        if(birthDate==null)
        	throw new IllegalArgumentException("passed arugement is null");
        this.birthDateTime = birthDateTime.of(birthDate,LocalTime.of(0,0));
    }

    Gigasecond(LocalDateTime birthDateTime) {
        if(birthDateTime==null)
        	throw new IllegalArgumentException("passed arugement is null");
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
     	return birthDateTime.plus(1000000000,ChronoUnit.SECONDS);
    }

}
