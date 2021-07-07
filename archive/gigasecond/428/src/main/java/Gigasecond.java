import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

class Gigasecond {

    private final static long gigaSecondValue = (long) Math.pow(10, 9);
    private LocalDate birthDate;
    private LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {

        return birthDateTime==null?birthDate.atStartOfDay().plusSeconds(gigaSecondValue):birthDateTime.plusSeconds(gigaSecondValue);
    }


}
