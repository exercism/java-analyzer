import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime time;
    private int gigasecond = 1000000000;

    Gigasecond(LocalDate moment) {
        //constructor of LocalDateTime from the passing LocalDate argument and giving it an IS0 time at midnight.
        this.time = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        //constructor of LocalDateTime from the passing LocalDateTime argument
        this.time = moment;
    }

    LocalDateTime getDateTime() {
        //returns new LocalDateTime to test a gigasecond after the moment
        return time.plusSeconds(gigasecond);
    }

}
