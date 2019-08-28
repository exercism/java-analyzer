import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private final LocalDateTime myBirthDateTime;

    // Let's assume the caller is diligent enough and we never get null in the
    // constructor.

    Gigasecond(LocalDate birthDate) {
        myBirthDateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        myBirthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        final long gigasecond = 1000000000;

        return myBirthDateTime.plusSeconds(gigasecond);
    }

}
