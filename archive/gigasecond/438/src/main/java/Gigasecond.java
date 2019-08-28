import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    LocalDateTime gigaSecondAge;
    static long gigaSecond = (long) Math.pow(10, 9);

    Gigasecond(LocalDate birthDate) {

        this.gigaSecondAge = birthDate.atStartOfDay();

    }

    Gigasecond(LocalDateTime birthDateTime) {

        this.gigaSecondAge = birthDateTime;

    }

    LocalDateTime getDateTime() {

        return this.gigaSecondAge.plusSeconds(Gigasecond.gigaSecond);

    }

}
