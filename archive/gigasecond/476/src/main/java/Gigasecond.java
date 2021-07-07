import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

class Gigasecond {

    private LocalDateTime dateTime;

    Gigasecond(LocalDate birthDate) {
        LocalDate localDate = Optional.ofNullable(birthDate).orElse(LocalDate.now());
        this.dateTime = localDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.dateTime = Optional.ofNullable(birthDateTime).orElse(LocalDateTime.now());
    }

    LocalDateTime getDateTime() {
        long gigaSeconds = (long) Math.pow(10,9);
        LocalDateTime plussedTime = dateTime.plusSeconds(gigaSeconds).withNano(0);
        return plussedTime;
    }

}

