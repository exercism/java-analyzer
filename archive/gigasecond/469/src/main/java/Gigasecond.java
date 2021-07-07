import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Gigasecond {

    private LocalDate birthDate;

    public Gigasecond(LocalDate birthDate) {
        this.birthDate = birthDate;

}

    public Gigasecond(LocalDateTime birthDateTime) {

        this.birthDate = birthDateTime.toLocalDate();
    }

    public LocalDateTime getDateTime() {
        LocalTime time = LocalTime.parse("01:46:40",
                DateTimeFormatter.ofPattern("HH:mm:ss"));
        return LocalDateTime.of( birthDate, LocalTime.now());
    }

}
