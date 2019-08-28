import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond
{
    private LocalDateTime moment;
    private static final long GIGASECOND = 1000000000;

    Gigasecond(LocalDate moment)
    {
        this.moment = moment.atTime(0, 0);
    }

    Gigasecond(LocalDateTime moment)
    {
        this.moment = moment;
    }

    LocalDateTime getDateTime()
    {
        return moment.plusSeconds(GIGASECOND);
    }
}
