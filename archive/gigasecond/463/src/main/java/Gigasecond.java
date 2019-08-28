import java.time.*;

class Gigasecond {

    private LocalDate birthDate;
    private LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        long epoch = 0;
        ZoneId zone = ZoneId.of("UTC+1");

        if(this.birthDate != null){
            epoch = this.birthDate.atStartOfDay(zone).toEpochSecond() + 1000_000_000;
        }else if(this.birthDateTime != null){
            epoch = this.birthDateTime.atZone(zone).toEpochSecond() + 1000_000_000;
        }
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(epoch), zone);
    }

}
