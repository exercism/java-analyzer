import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

class Gigasecond {
    private LocalDateTime dateTime;

    Gigasecond(LocalDate moment) {
        this(moment.atTime(0,0));
    }

    Gigasecond(LocalDateTime moment) {
        long epochSecond = moment.toEpochSecond(ZoneOffset.UTC);
        epochSecond += Long.valueOf("1000000000");
        dateTime = LocalDateTime.ofEpochSecond(epochSecond, 0, ZoneOffset.UTC);
    }

    LocalDateTime getDateTime() {
        return dateTime;
    }

}
