import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

class Gigasecond {
    private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = LocalDateTime.of(moment.getYear(), moment.getMonthValue(), moment.getDayOfMonth(), 0, 0, 0);
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        ZoneId zone = ZoneId.systemDefault();
        long second = moment.atZone(zone).toInstant().toEpochMilli() + 1000000000000L;
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(second), zone);
    }

}
