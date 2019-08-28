import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("Birthdate can't be null.");
        }
        this.birthDateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        if (birthDateTime == null) {
            throw new IllegalArgumentException("Birthdate can't be null.");
        }
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return this.birthDateTime.plusSeconds((long) Math.pow(10, 9));
    }
}
