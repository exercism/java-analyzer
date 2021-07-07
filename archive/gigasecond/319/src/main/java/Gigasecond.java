import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigInteger;

public class Gigasecond {
    private final LocalDateTime date;
    private static final Long GIGASECOND = BigInteger
            .valueOf(10)
            .pow(9)
            .longValue();

    public Gigasecond(LocalDate date) {
        this(date.atStartOfDay());
    }

    public Gigasecond(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date.plusSeconds(GIGASECOND);
    }
}