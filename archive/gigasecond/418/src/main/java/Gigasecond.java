import java.time.*;

class Gigasecond {

    public static final int     GIGASECONDS = 1000000000;
    private final LocalDateTime birthdatetime;

    Gigasecond(LocalDate birthDate) {
        birthdatetime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        birthdatetime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return birthdatetime.plusSeconds(GIGASECONDS);
    }

}
