import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

class Gigasecond {
    private long epochSeconds;
    private static long GIGASECONDS = 1000 * 1000 * 1000;
    Gigasecond(LocalDate moment) {
        this.epochSeconds = moment.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
    }

    Gigasecond(LocalDateTime moment) {
        this.epochSeconds = moment.atZone(ZoneId.systemDefault()).toEpochSecond();
    }

    LocalDateTime getDateTime() {
        long epochMilliseconds = (this.epochSeconds + GIGASECONDS) * 1000;
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilliseconds), ZoneId.systemDefault());
    }
}
