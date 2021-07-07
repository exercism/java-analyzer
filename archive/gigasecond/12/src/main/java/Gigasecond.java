import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    LocalDateTime dateTime;

    Gigasecond(LocalDate moment) {
        this.dateTime = moment.atStartOfDay(); //Convert a passed in LocalDat to a LocalDatTime
    }

    Gigasecond(LocalDateTime moment) {
        this.dateTime = moment;
    }

    LocalDateTime getDateTime() {
        //Add a gigasecond to the passed in moment
        return dateTime.plusSeconds(1000000000);
    }
}
