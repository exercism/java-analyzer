import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime _gigaSecond;

    private LocalDateTime parseGigasecond(LocalDateTime moment) {
        return moment.plusSeconds(1000000000);
    }

    Gigasecond(LocalDate moment) {
        _gigaSecond = this.parseGigasecond(moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        _gigaSecond = this.parseGigasecond(moment);
    }

    LocalDateTime getDateTime() {
        return this._gigaSecond;
    }

}
