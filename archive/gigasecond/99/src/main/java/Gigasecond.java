import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime gS;

    Gigasecond(LocalDate moment) {
        this(LocalDateTime.of(moment.getYear(), moment.getMonthValue(), moment.getDayOfMonth(), 0, 0));
    }

    Gigasecond(LocalDateTime moment) {
        gS = moment.plusSeconds(1000000000);
    }

    LocalDateTime getDateTime() {
        return gS;
    }

}
