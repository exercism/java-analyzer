import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    LocalDateTime birth;

    Gigasecond(LocalDate birthDate) {
        birth = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        birth = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return birth.plusSeconds((long)Math.pow(10,9));
    }

}
