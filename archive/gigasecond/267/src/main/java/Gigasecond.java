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
        LocalDateTime localDateTime= null;
        if (birthDate!=null){
            localDateTime = LocalDateTime.of(birthDate, LocalTime.of(0,0)).plus(1000000000, ChronoUnit.SECONDS);
        }
        if (birthDateTime!=null){
            localDateTime = birthDateTime.plus(1000000000, ChronoUnit.SECONDS);
        }
        return localDateTime;
    }

}
