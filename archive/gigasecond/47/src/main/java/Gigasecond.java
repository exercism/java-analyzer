import java.time.LocalDate;
import java.time.LocalDateTime;
 
class Gigasecond {

    private LocalDateTime answer;
    Gigasecond(LocalDate moment) {
        this.answer = moment.atTime(0, 0);
    }

    Gigasecond(LocalDateTime moment) {
        this.answer = moment;
    }

    LocalDateTime getDateTime() {

        return answer.plusSeconds((long)1E+9);
    }

}
