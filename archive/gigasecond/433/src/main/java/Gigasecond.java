import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final LocalDateTime time;

    Gigasecond(LocalDate birthDate) 
    {
       // throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
       time=birthDate.atStartOfDay().plusSeconds(1000000000);
    }

    Gigasecond(LocalDateTime birthDateTime) 
    {
      //  throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        time=birthDateTime.plusSeconds(1000000000);

    }

    LocalDateTime getDateTime() {
        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        return time;
    }

}
