import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime localDateTime;
    private static long GIGASECONDS = 1000000000L;

    public Gigasecond(LocalDate localDate) {
        this.localDateTime = localDate.atStartOfDay();
    }

    public Gigasecond(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getDateTime() {
        return localDateTime.plusSeconds(GIGASECONDS);
    }

}
