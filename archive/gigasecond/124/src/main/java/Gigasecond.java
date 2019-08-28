import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

class Gigasecond {

    private LocalDateTime added;

    public Gigasecond(Temporal moment) {
        added = moment instanceof LocalDateTime
              ? ((LocalDateTime) moment).plusSeconds(1000000000)
              : ((LocalDate) moment).atStartOfDay().plusSeconds(1000000000);
    }

    public LocalDateTime getDateTime() { return added; }

}
