import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {

    LocalDateTime iLocalDateTime;
    LocalDateTime iFinalAnswer;
    long iTenPower9 = 1000000000;

    Gigasecond(LocalDate moment) {

        iLocalDateTime = moment.atStartOfDay();
        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    Gigasecond(LocalDateTime moment) {
        iLocalDateTime = moment;
        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    LocalDateTime getDateTime() {
        iFinalAnswer = iLocalDateTime.plus(iTenPower9, ChronoUnit.SECONDS);
        return iFinalAnswer;
        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}
