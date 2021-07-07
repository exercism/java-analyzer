import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    LocalDateTime _date;
    Gigasecond(LocalDate moment) {
        _date = LocalDateTime.of(moment.getYear(), moment.getMonth(), moment.getDayOfMonth(), 0, 0, 0);
    }

    Gigasecond(LocalDateTime moment) {
        _date = moment;
    }

    LocalDateTime getDateTime() {
        _date =_date.plusSeconds(1000000000);
        return _date;
    }

}
