import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime t;

    Gigasecond(LocalDate birthDate) {

            t = birthDate.atTime(0,0);
    }

    Gigasecond(LocalDateTime birthDateTime) {
            
            t = birthDateTime;
    }

    LocalDateTime getDateTime() {
        
        return t.plusSeconds(1000000000);
    }

}
