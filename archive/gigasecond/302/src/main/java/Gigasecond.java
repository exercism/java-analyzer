import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    LocalDateTime dateTime;

    private static long GIGA_SECOND = 1000000000L;


    Gigasecond(LocalDate birthDate) {
        computeNewDate(birthDate.atStartOfDay());
    }

    Gigasecond(LocalDateTime birthDateTime) {
        computeNewDate(birthDateTime);
    }

    private void computeNewDate(LocalDateTime localDateTime) {
        dateTime = localDateTime.plusSeconds(GIGA_SECOND);
    }

    LocalDateTime getDateTime() {
        return dateTime;
    }

}
