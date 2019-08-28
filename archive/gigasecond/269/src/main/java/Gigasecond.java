import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    LocalDateTime dateTime;

    Gigasecond(LocalDate birthDate) {
        this.dateTime = LocalDateTime.of(birthDate.getYear(), birthDate.getMonth(), birthDate.getDayOfMonth(), 0, 0, 0);
        this.addGigasecond();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.dateTime = birthDateTime;
        this.addGigasecond();
    }

    private void addGigasecond(){
        this.dateTime = this.dateTime.plusSeconds(1000000000);
    }

    LocalDateTime getDateTime() {
        return dateTime;
    }

}
