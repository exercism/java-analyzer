import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

class Gigasecond {

    LocalDateTime localDateTime;

    Gigasecond(LocalDate birthDate) {
        this.localDateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.localDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        Long tenToNinth = new Long((long) Math.pow(10,9));
        return this.localDateTime.plusSeconds( tenToNinth );
    }

}
