import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    LocalDateTime result;

    Gigasecond(LocalDate moment) {
        this.result = moment.atTime(0,0,0);
    }

    Gigasecond(LocalDateTime moment) {
        this.result = moment;
    }

    LocalDateTime getDateTime() {
        return this.result.plusSeconds((int) Math.pow(10, 9));
    }

}
