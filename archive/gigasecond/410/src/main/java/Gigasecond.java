import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

class Gigasecond {

 LocalDateTime birthDateTime;
 LocalDate birthDate;

    Gigasecond(LocalDate birthDate) {
this.birthDateTime=  LocalDateTime.of(birthDate.getYear(),birthDate.getMonth(), birthDate.getDayOfMonth(),0,0,0);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime=birthDateTime;

    }

    LocalDateTime getDateTime() {
       return birthDateTime.plusSeconds(1000000000);}

    }




