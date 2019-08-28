import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

class Gigasecond {

    private static final int GIGASEC = (int) Math.pow(10, 9);

    private LocalDateTime newLocalDateTime;

    Gigasecond(LocalDate birthDate) {
        LocalDateTime localDateTime = birthDate.atStartOfDay();
        this.newLocalDateTime = localDateTime.plus(GIGASEC, ChronoField.SECOND_OF_DAY.getBaseUnit());
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.newLocalDateTime = birthDateTime.plus(GIGASEC, ChronoField.SECOND_OF_DAY.getBaseUnit());
    }

    LocalDateTime getDateTime() {
        return newLocalDateTime;
    }

}
