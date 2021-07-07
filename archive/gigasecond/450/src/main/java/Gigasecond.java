import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime gigasecondTime;

    Gigasecond(LocalDate birthDate) {
        this.gigasecondTime = birthDate.atTime(0,0).plusSeconds((long) Math.pow(10,9));
    }

    Gigasecond(LocalDateTime gigasecondTime) {
        this.gigasecondTime = gigasecondTime.plusSeconds((long) Math.pow(10,9));
    }

    LocalDateTime getDateTime() {
        return this.gigasecondTime;
    }

}
