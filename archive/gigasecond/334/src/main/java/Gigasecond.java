import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private static final long GIGASECOND = 1000000000L;
    private LocalDateTime birthDateTime=null;
    
    Gigasecond(LocalDate birthDate) {
       this(birthDate.atStartOfDay());
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime.plusSeconds(GIGASECOND);
    }

    LocalDateTime getDateTime() {
        return birthDateTime;
    }
}
