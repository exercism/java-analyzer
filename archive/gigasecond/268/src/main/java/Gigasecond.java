import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    private LocalDateTime localDateTime;

    Gigasecond(LocalDate birthDate) {
        this.localDateTime = LocalDateTime.of(birthDate, LocalTime.of(0,0,0));
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.localDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return localDateTime.plusSeconds(1000000000);
    }

}
