import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

class Gigasecond {

    LocalDate localDateMoment;
    LocalDateTime localDateTimeMoment;

    Gigasecond(LocalDate moment) {
        this.localDateMoment = moment;
    }

    Gigasecond(LocalDateTime moment) {
        this.localDateTimeMoment = moment;
    }

    LocalDateTime getDateTime() {

        // return Optional.ofNullable(localDateTimeMoment).orElse(localDateMoment.atTime(0, 0)).plusSeconds(1000000000);

        if(localDateMoment == null){
            return localDateTimeMoment.plusSeconds(1000000000);
        } else{
            return localDateMoment.atTime(0, 0).plusSeconds(1000000000);
        }
    }

}
