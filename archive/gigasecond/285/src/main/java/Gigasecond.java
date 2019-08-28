import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime localDate;

    Gigasecond(LocalDate birthDate) {
        this.localDate = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.localDate = birthDateTime;
    }

    LocalDateTime getDateTime() {

        return localDate.plusSeconds((long) Math.pow(10, 9));

    }

}
