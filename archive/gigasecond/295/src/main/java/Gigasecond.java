import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    long secondAdd = 1000000000;
    LocalDateTime time;

    Gigasecond(LocalDate birthDate) {
        time = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        time = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return time.plusSeconds(secondAdd);
    }

}
