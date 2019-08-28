import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime pBirthTS;

    Gigasecond(LocalDate birthDate) {
        this.pBirthTS = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.pBirthTS = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return pBirthTS.plusSeconds(1000000000);
    }

}
