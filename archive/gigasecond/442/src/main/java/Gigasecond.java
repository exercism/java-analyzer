import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDate afterGiga;

    Gigasecond(LocalDate birthDate) {
        int newYear = birthDate.getYear() + 31;
        int newMonth = birthDate.getMonthValue() + 8;

        newMonth = newMonth%12
    }

    Gigasecond(LocalDateTime birthDateTime) {
    }

    LocalDateTime getDateTime() {
    }

}
