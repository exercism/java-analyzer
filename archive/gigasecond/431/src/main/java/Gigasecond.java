import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private long gigaseconds = 1000000000;
    private LocalDateTime localDateTime;

    Gigasecond(LocalDate birthDate) {
        this.localDateTime = birthDate.atStartOfDay(); //converts LocalDate to LocalDateTime
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.localDateTime = birthDateTime; 
    }

    LocalDateTime getDateTime() {
        return localDateTime.plusSeconds(gigaseconds); 
    }

}
