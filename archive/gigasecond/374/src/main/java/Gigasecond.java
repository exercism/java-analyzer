import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDateTime date;

    Gigasecond(LocalDate birthDate) {
        date = computeDate(birthDate.atStartOfDay());
    }

    Gigasecond(LocalDateTime birthDateTime) {
        date = computeDate(birthDateTime);
    }

    LocalDateTime getDateTime() {
        return date;
    }

    private LocalDateTime computeDate(LocalDateTime birthDateTime) {
        return birthDateTime.plusSeconds(1_000_000_000);
    }

}
