package gigasecond.src.main.java;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    private LocalDateTime birthDateTime;

    public Gigasecond(LocalDate birthDate) {
        birthDateTime = birthDate.atStartOfDay();
    }

    public Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    public LocalDateTime getDateTime() {
        return birthDateTime.plusSeconds(1000000000L);
    }

}
