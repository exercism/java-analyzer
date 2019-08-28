import java.time.LocalDateTime;
import java.time.LocalDate;

public class Gigasecond {

    private LocalDateTime birthDateTime;

    public Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    public Gigasecond(LocalDate birthDate) {
        this.birthDateTime = birthDate.atTime(0, 0);
    }

    public LocalDateTime getDateTime() {
        return birthDateTime.plusSeconds(1000000000);
    }

}