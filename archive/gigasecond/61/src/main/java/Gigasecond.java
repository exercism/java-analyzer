import java.math.BigDecimal;
import java.time.*;

class Gigasecond {

    private Long moment;
    Gigasecond(LocalDate moment) {
        this.moment = moment.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();;
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    LocalDateTime getDateTime() {
        BigDecimal result = new BigDecimal(this.moment.toString()).add(new BigDecimal("1000000000000"));

        return Instant.ofEpochMilli(result.longValue())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}
