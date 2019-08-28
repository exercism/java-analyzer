import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

    //private LocalDate birthDate;
    private LocalDateTime birthDateTime;
    private long gigaSecond = 1000000000;

    Gigasecond(LocalDate birthDate) {
        //this.birthDate = birthDate;
        this.birthDateTime = LocalDateTime.of(birthDate, LocalTime.MIN);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return this.birthDateTime.plusSeconds(gigaSecond);
    }

}
