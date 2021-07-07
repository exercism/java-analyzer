import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond
{

	private LocalDateTime timestamp = null;

    Gigasecond(LocalDate birthDate)
    {
        this.timestamp = birthDate.atTime(0, 0);;
    }

    Gigasecond(LocalDateTime birthDateTime)
    {
        this.timestamp = birthDateTime;
    }

    LocalDateTime getDateTime()
    {
        return this.timestamp.plusSeconds(1000000000);
    }

}
