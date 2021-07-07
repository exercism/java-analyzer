import java.time.*;

class Gigasecond {

    private Long dobInSeconds;

    Gigasecond(LocalDate birthDate) {
        this.dobInSeconds = birthDate.atStartOfDay().toEpochSecond(ZoneOffset.UTC);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.dobInSeconds = birthDateTime.toEpochSecond(ZoneOffset.UTC);
    }

    LocalDateTime getDateTime() {
        return LocalDateTime.ofInstant(
                Instant.ofEpochSecond(this.dobInSeconds),
                ZoneId.ofOffset("UTC", ZoneOffset.UTC)
        ).plusSeconds(new Double(Math.pow(10,9)).longValue());
    }
}
