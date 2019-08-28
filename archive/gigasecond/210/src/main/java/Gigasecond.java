import java.time.*;

class Gigasecond {

    long seconds = 1000000000;
    long dateInSecFromEpoch;

    Gigasecond(LocalDate birthDate) {

        this.dateInSecFromEpoch = birthDate.atStartOfDay(ZoneOffset.UTC).toEpochSecond();
    }

    Gigasecond(LocalDateTime birthDateTime) {

        this.dateInSecFromEpoch = birthDateTime.toEpochSecond(ZoneOffset.UTC);
    }

    LocalDateTime getDate() {

        return LocalDateTime.ofEpochSecond(seconds + dateInSecFromEpoch, 0, ZoneOffset.UTC);
    }

}
