import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

class Gigasecond {

    private static final long GIGA_SECONDS = 1000000000L;
    private LocalDate birthDate;
    private LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
        this.birthDate= birthDate;
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime=birthDateTime;
    }

    LocalDateTime getDateTime() {
        return birthDate==null? calculateFinalDateTime(birthDateTime.atZone(ZoneOffset.systemDefault())):
                birthDateTime==null? calculateFinalDateTime(birthDate.atStartOfDay(ZoneOffset.systemDefault())):
                        null;
    }

    private LocalDateTime calculateFinalDateTime(ZonedDateTime birthDateTime) {
        int day = (int)TimeUnit.SECONDS.toDays(GIGA_SECONDS);
        long hours = TimeUnit.SECONDS.toHours(GIGA_SECONDS) - (day *24);
        long minute = TimeUnit.SECONDS.toMinutes(GIGA_SECONDS) - (TimeUnit.SECONDS.toHours(GIGA_SECONDS)* 60);
        long second = TimeUnit.SECONDS.toSeconds(GIGA_SECONDS) - (TimeUnit.SECONDS.toMinutes(GIGA_SECONDS) *60);

        ZonedDateTime newDate = birthDateTime.plus(day, ChronoUnit.DAYS);
        ZonedDateTime newDateHours = newDate.plus(hours, ChronoUnit.HOURS);
        ZonedDateTime newDateMinute = newDateHours.plus(minute, ChronoUnit.MINUTES);
        ZonedDateTime newDateSecond = newDateMinute.plus(second, ChronoUnit.SECONDS);
        return  LocalDateTime.of(newDateSecond.toLocalDate(), newDateSecond.toLocalDateTime().toLocalTime());
    }
}
