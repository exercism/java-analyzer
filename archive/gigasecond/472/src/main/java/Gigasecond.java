import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDateTime datetime;


    Gigasecond(LocalDate birthDate) {
        this.datetime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.datetime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return this.datetime.plusSeconds(1000000000);
    }

}
