import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Gigasecond {
    private LocalDateTime time;

    public Gigasecond(LocalDate birthDate) {
        this(birthDate.atTime(0, 0));
    }

    public Gigasecond(LocalDateTime birthDateTime) {
        this.time = birthDateTime.plus(1_000_000_000, ChronoUnit.SECONDS);
    }

    public LocalDateTime getDateTime() {
        return this.time;
    }

}
