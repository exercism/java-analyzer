import java.time.*;
import java.math.BigInteger;

class Gigasecond {

    private LocalDateTime dateToAdd;

    Gigasecond(LocalDate moment) {
        dateToAdd = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        dateToAdd = moment;
    }

    LocalDateTime getDateTime() {
        BigInteger gigasec = new BigInteger("10").pow(9);
        LocalDateTime newMoment = dateToAdd.plusSeconds(gigasec.longValue());
        return newMoment;
    }

}
