import java.time.LocalDate;
import java.time.LocalDateTime;


class Gigasecond {
    private LocalDateTime birthDate;

    Gigasecond(LocalDate birthDate) {
        this.birthDate = birthDate.atTime(0,0);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDate = birthDateTime;
    }

    public LocalDateTime getDateTime() {
        return this.birthDate.plusSeconds((int) Math.pow(10, 9));
    }

}
