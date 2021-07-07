import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    LocalDate birthDate;
    LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
       this.birthDate = birthDate;
    }

    Gigasecond(LocalDateTime birthDateTime) {
       this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        if(birthDateTime != null) {
            return birthDateTime.plus((long)Math.pow(10, 9), ChronoUnit.SECONDS);
        }
        return LocalDateTime.of(
                birthDate.plus((long)(Math.pow(10, 9)/86400),ChronoUnit.DAYS),
                LocalTime.of(1 ,46, 40));
    }

}
