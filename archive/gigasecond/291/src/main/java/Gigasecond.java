import java.time.*;

class Gigasecond
{
    LocalDateTime birthDate;
    
    Gigasecond (LocalDate birthDate)
    {
        this.birthDate = LocalDateTime.of(birthDate, LocalTime.of(0, 0));
    }
    
    Gigasecond (LocalDateTime birthDateTime)
    {
        birthDate = birthDateTime;
    }
    
    LocalDateTime getDateTime ()
    {
        return birthDate.plusSeconds(1_000_000_000);
    }
}
