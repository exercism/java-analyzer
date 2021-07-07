
import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final LocalDateTime dateTime;
    private final int lifeDuringSeconds = (int) Math.pow(10, 9);

    Gigasecond(final LocalDate birthDate) {
        dateTime = birthDate.atStartOfDay().plusSeconds(lifeDuringSeconds);
    }

    Gigasecond(final LocalDateTime birthDateTime) {
        dateTime = birthDateTime.plusSeconds(lifeDuringSeconds);
    }

    LocalDateTime getDateTime() {
        return dateTime;
    }

}
