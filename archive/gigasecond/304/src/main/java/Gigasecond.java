import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

class Gigasecond {
     LocalDate birthDate;
     LocalDateTime birthDateTime;
    Gigasecond(LocalDate birthDate) {
       this.birthDate=birthDate;
       this.birthDateTime=LocalDateTime.of(birthDate,LocalTime.of(0,0,0));
    }

    Gigasecond(LocalDateTime birthDateTime) {
       this.birthDateTime=birthDateTime;
    }

    LocalDateTime getDateTime() {
        LocalDateTime gigasecond=birthDateTime.plusSeconds(1000000000);
        return gigasecond;
    }
    
    public static void main(String args[]) {
    	 Gigasecond gigaSecond = new Gigasecond(LocalDate.of(2011, Month.APRIL, 25));
    	 System.out.println(gigaSecond.getDateTime());
    }

}
