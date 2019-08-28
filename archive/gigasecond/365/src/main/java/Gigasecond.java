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
        return birthDate == null? birthDateTime.plus(Duration.ofSeconds(1000000000)):birthDate.atTime(0,0).plus(Duration.ofSeconds(1000000000));
    }

}
