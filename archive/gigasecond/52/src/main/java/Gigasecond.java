import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

class Gigasecond {

    int time = 1000000000;
    LocalDate localDate;
    LocalDateTime localDateTime;
    Date date;

    Gigasecond(LocalDate moment) {
        this.localDate = moment;
        ZoneId zoneId = ZoneId.of("GMT");
        Instant instant = localDate.atStartOfDay().atZone(zoneId).toInstant();
        date = Date.from(instant);
    }

    Gigasecond(LocalDateTime moment) {
        this.localDateTime = moment;
        ZoneId zoneId = ZoneId.of("GMT");
        Instant instant = localDateTime.atZone(zoneId).toInstant();
        date = Date.from(instant);
    }

    LocalDateTime getDateTime() {
        Calendar time = Calendar.getInstance();
        time.setTime(date);
        time.add(Calendar.DAY_OF_YEAR, getDay());
        time.add(Calendar.SECOND,getRestSec());
        Instant instant = time.getTime().toInstant();
        ZoneId zoneId = ZoneId.of("GMT");

        return LocalDateTime.ofInstant(instant,zoneId);

    }

    private int getDay() {
        return time / 24 / 3600;
    }

    private int getRestSec() {
        return time % 86400;
    }

}
