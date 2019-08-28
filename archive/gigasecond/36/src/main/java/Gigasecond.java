import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

class Gigasecond {
    long timestamp;

    Gigasecond(LocalDate moment) {
        timestamp = moment.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
    }

    Gigasecond(LocalDateTime moment) {
        timestamp = moment.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }

    LocalDateTime getDateTime() {
        return Instant.ofEpochMilli(timestamp + 1000000000000l).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }

}
