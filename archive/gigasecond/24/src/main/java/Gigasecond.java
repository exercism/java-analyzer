import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond
{
  private LocalDateTime time;
  private int           gigasecond = 1000000000;

  Gigasecond( LocalDate moment )
  {
    this.time = moment.atStartOfDay();
  }

  Gigasecond( LocalDateTime moment )
  {
    this.time = moment;
  }

  LocalDateTime getDateTime()
  {
    return time.plusSeconds( gigasecond );


  }

}
