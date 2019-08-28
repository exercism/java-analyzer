import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond
{
    private LocalDateTime after;

    Gigasecond(LocalDate moment)
    {
        after = moment.atStartOfDay().plus(1000000000, ChronoUnit.SECONDS);
    }

    Gigasecond(LocalDateTime moment)
    {
        after = moment.plus(1000000000, ChronoUnit.SECONDS);
    }

    LocalDateTime getDateTime()
    {
        return after;
    }

}
