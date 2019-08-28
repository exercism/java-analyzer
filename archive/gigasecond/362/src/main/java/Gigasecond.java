import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDateTime _age;

    Gigasecond(LocalDate birthDate) {
        _age = birthDate.atStartOfDay().plusSeconds((long)1e9);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        _age = birthDateTime.plusSeconds((long)1e9);
    }

    LocalDateTime getDateTime() {
        return _age;
    }

}
