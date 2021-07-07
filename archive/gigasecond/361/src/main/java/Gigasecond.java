import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDate birthDate;

    private LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        LocalDateTime localDateTime = null;
        long plusSeconds = (long) Math.pow(10, 9);
        if (birthDate != null) {
            birthDateTime = birthDate.atTime(0, 0);
        }
        localDateTime = birthDateTime.plusSeconds(plusSeconds);

        return localDateTime;
    }
}
