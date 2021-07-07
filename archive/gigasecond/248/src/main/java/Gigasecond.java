import java.time.*;

class Gigasecond {

    private LocalDate localDate;
    private LocalDateTime localDateTime;
    private static long gigaSec = (long) Math.pow(10, 9);

    Gigasecond(LocalDate moment) {
        this.localDate = moment;
    }

    Gigasecond(LocalDateTime moment) {
        this.localDateTime = moment;
    }

    LocalDateTime getDateTime() {
        if(localDate != null) {
            return LocalDateTime
                    .ofEpochSecond(
                            this.localDate
                                    .atStartOfDay()
                                    .toInstant(ZoneOffset.UTC)
                                    .getEpochSecond() + gigaSec, 0, ZoneOffset.UTC);
        } else {
            return LocalDateTime
                    .ofEpochSecond(
                            this.localDateTime
                                    .toInstant(ZoneOffset.UTC)
                                    .getEpochSecond() + gigaSec, 0, ZoneOffset.UTC);
        }
    }

}
