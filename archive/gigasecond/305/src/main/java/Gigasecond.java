import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

class Gigasecond {

    private static  final long addedSeconds = new Double(Math.pow(10,9)).longValue();
    private LocalDateTime localDateTime;

    Gigasecond(LocalDate moment) {
        localDateTime = addSecondToDateTime(LocalDateTime.of(moment,LocalTime.of(0,0)), addedSeconds);
    }

    Gigasecond(LocalDateTime moment) {
        localDateTime = addSecondToDateTime(moment, addedSeconds);
    }

    LocalDateTime getDateTime() {
        return localDateTime;
    }

    private LocalDateTime addSecondToDateTime(LocalDateTime localDateTime,long seconds){
        ZonedDateTime zonedDateTime = ZonedDateTime
                .ofInstant(
                        new Date(localDateTime.toEpochSecond(ZoneOffset.UTC)*1000).toInstant(),
                        ZoneId.ofOffset("UTC",ZoneOffset.UTC)
                );
        zonedDateTime = zonedDateTime.plus(seconds, ChronoUnit.SECONDS);
        return LocalDateTime.ofEpochSecond(zonedDateTime.toEpochSecond(),0,ZoneOffset.UTC);
    }

}


