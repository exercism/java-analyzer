import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.TimeZone;

class Gigasecond {

    private static final int gigaSecond = 1000000000;

    private LocalDateTime localDateTime;

    private void setLocalDateTime(LocalDateTime dateTime){
        this.localDateTime = dateTime;
    }

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }
    Gigasecond(LocalDateTime moment) {
       setLocalDateTime(moment.plus(gigaSecond, ChronoUnit.SECONDS));
    }

    LocalDateTime getDateTime() {
        return localDateTime;
    }


}
