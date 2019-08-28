import java.time.*;
import java.util.Date;

class Gigasecond {

    LocalDateTime localDateTime;
    LocalDate localDate;
    int gigasecond = 1000000000;

    Gigasecond(LocalDate moment) {
        this.localDate = moment;
    }

    Gigasecond(LocalDateTime moment) {
        this.localDateTime = moment;
    }

    LocalDateTime getDateTime() {

        if(localDate!=null) {
        Instant instant = Instant
                            .ofEpochSecond(new Date(localDate.toEpochDay()*24*3600 + gigasecond)
                            .getTime());
        localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        }

        else if(localDateTime!=null){
        ZoneOffset zoneOffset = ZoneId.systemDefault().getRules().getOffset(localDateTime);
        Long expectedTimestamp = localDateTime.toEpochSecond(zoneOffset) + gigasecond;
        Instant instant = Instant.ofEpochSecond(expectedTimestamp);
        localDateTime = LocalDateTime.ofInstant(instant, zoneOffset);
        }

        else
           throw new IllegalArgumentException("Date format is incorrect or empty");
        return localDateTime;

    }
}
