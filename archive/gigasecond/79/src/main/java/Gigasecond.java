import java.time.*;


class Gigasecond {

    LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        LocalDateTime localDateTime = LocalDateTime.of(moment, LocalTime.MIN);
        this.moment = localDateTime;
    }


    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }


    LocalDateTime getDateTime() {

        ZoneOffset zoneOffset = ZoneOffset.ofHours(0);
        OffsetDateTime offsetDateTime = moment.atOffset(zoneOffset);

        OffsetDateTime plusGigaSeconds = offsetDateTime.plusSeconds(1000000000);
        return plusGigaSeconds.toLocalDateTime();
    }

}
