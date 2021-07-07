import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

class Gigasecond {

    //Calculate the moment when someone has lived for 10^9 seconds.
    //A gigasecond is 10^9 (1,000,000,000) seconds.
    private final LocalDateTime gigasecond; 

    Gigasecond(LocalDate birthDate) {
        LocalDateTime convertDate = LocalDateTime.of(birthDate, LocalTime.MIN);
        gigasecond = convertDate.plusSeconds(1000000000);
        
    }

    Gigasecond(LocalDateTime birthDateTime) {
        gigasecond = birthDateTime.plusSeconds(1000000000);
        System.out.println(gigasecond);
    }

    LocalDateTime getDateTime() {
        return gigasecond;
    }

}
