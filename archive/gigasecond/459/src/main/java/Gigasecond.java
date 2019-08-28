import java.time.*;

class Gigasecond {

    private long dateInSeconds;
    private long offsetInSeconds = 1000000000;
    private final ZoneOffset zone = ZoneOffset.UTC;

    Gigasecond(LocalDate birthDate) {
       dateInSeconds = (birthDate.toEpochDay() * 24 * 3600) + offsetInSeconds;
    }

    Gigasecond(LocalDateTime birthDateTime) {
        dateInSeconds = birthDateTime.atOffset(zone).toEpochSecond() + offsetInSeconds;
    }

    LocalDateTime getDateTime() {
         return Instant.ofEpochSecond(dateInSeconds).atOffset(zone).toLocalDateTime();
    }

}
