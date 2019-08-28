import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDateTime ldtm;
    private final long GIGASEC = 1000000000;

    Gigasecond(LocalDate moment) {
        this.ldtm = LocalDateTime.of(moment.getYear(), moment.getMonth(), moment.getDayOfMonth(), 0, 0).plusSeconds(GIGASEC); 
    }

    Gigasecond(LocalDateTime moment) {
        this.ldtm = moment.plusSeconds(GIGASEC);
    }

    LocalDateTime getDateTime() {
   
        return ldtm;
    }

}
