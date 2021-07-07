import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime birthday;

    Gigasecond(LocalDate birthDate) {
        birthday = LocalDateTime.of(birthDate.getYear(), birthDate.getMonthValue(), birthDate.getDayOfMonth(), 0, 0, 0);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        birthday = birthDateTime;
    }

    LocalDateTime getDateTime() {
        // unsure if this calculation is better done once and stored?
        return birthday.plusSeconds(1000000000);
    }

}
