import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime gigasecond;
    private static final long GIGASECOND = Math.round(Math.pow(10,9));

    Gigasecond(LocalDate birthDate) {
        gigasecond = birthDate.atTime(0,0).plusSeconds(GIGASECOND);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        gigasecond = birthDateTime.plusSeconds(GIGASECOND);
    }

    LocalDateTime getDateTime() {
        return gigasecond;
    }

}
