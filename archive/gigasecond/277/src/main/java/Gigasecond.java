import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime dateTime;

    Gigasecond(LocalDate birthDate) {

        this.dateTime = calculateGigasecond(birthDate.atStartOfDay());

    }

    Gigasecond(LocalDateTime birthDateTime) {

        this.dateTime = calculateGigasecond(birthDateTime);

    }

    private LocalDateTime calculateGigasecond(LocalDateTime birthDateTime) {

        return birthDateTime.plusSeconds((long) Math.pow(10, 9));

    }

    LocalDateTime getDateTime() {

        return dateTime;

    }

}
