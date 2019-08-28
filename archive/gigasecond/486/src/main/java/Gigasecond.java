import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private static long GIGASECOND = 1000000000;
    private LocalDateTime time;

    public Gigasecond(LocalDate birthDate) {

        time = birthDate.atStartOfDay();
    }

    public Gigasecond(LocalDateTime birthDateTime) {

        time = birthDateTime;
    }

    public LocalDateTime getDateTime() {

        return time.plusSeconds(GIGASECOND);
        
    }

}
