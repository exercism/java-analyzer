import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    final static    long            GIGASECONDS = 1000000000L;
    final           LocalDateTime   dateTime;

    Gigasecond(LocalDate moment)
    {
        dateTime = LocalDateTime.of( moment, LocalTime.MIN ).plusSeconds( GIGASECONDS );
    }

    Gigasecond(LocalDateTime moment)
    {
        dateTime = moment.plusSeconds( GIGASECONDS );
    }

    LocalDateTime getDateTime( )
    {
        return dateTime;
    }

}
