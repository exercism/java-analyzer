import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

class Gigasecond {

    private LocalDate birthDate;
    private LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {

        this.birthDate = birthDate;
        this.birthDateTime = null;

    }

    Gigasecond(LocalDateTime birthDateTime) {

        this.birthDateTime = birthDateTime;
        this.birthDate = null;

    }

    LocalDateTime getDateTime() {

        LocalDateTime time = checkDateTime();

        time = time.plusSeconds((long) Math.pow(10, 9));

        return time;
    }

    LocalDateTime checkDateTime() {

        if (birthDateTime == null)
            return birthDate.atStartOfDay();

        return birthDateTime;

    }

}
