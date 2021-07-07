import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
	LocalDateTime birthDate;

    Gigasecond(LocalDate birthDate) {
    	this.birthDate = LocalDateTime.of(birthDate.getYear(), birthDate.getMonth(), birthDate.getDayOfMonth(), 0, 0);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDate = birthDateTime;
    }

    LocalDateTime getDateTime() {
        return this.birthDate.plusSeconds((int) Math.pow(10, 9));
    }
}
