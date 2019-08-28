import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDateTime localdate;

    Gigasecond(LocalDate birthDate) {
        localdate = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        localdate = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return localdate.plusSeconds(1000000000);
    }

}
