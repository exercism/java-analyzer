import java.time.*;


class Gigasecond {
    long giga = 1000000000;
    long date;
    Gigasecond(LocalDate moment) {
        this.date = moment.atStartOfDay(ZoneOffset.UTC).toEpochSecond();
    }

    Gigasecond(LocalDateTime moment) {
        this.date = moment.toEpochSecond(ZoneOffset.UTC);
    }

    LocalDateTime getDateTime() {
        return LocalDateTime.ofEpochSecond(date + giga, 0 , ZoneOffset.UTC);
    }
}
