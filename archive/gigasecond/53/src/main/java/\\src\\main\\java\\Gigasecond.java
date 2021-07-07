import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.SECONDS;

class Gigasecond {

     LocalDateTime momentDateTime;
     LocalDate momentDate;

    Gigasecond(LocalDate moment) {
        this.momentDate = moment;
    }

    Gigasecond(LocalDateTime moment) {
        this.momentDateTime = moment;
    }

    LocalDateTime getDateTime() {
        if (momentDateTime != null) return momentDateTime.plusSeconds((long)Math.pow(10, 9));

        if (momentDate != null) {
            LocalDateTime ldt = momentDate.atStartOfDay();
            return ldt.plus((long)Math.pow(10, 9), SECONDS);
        }
        return LocalDateTime.now();
    }

}
