import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

	LocalDateTime birth;

    Gigasecond(LocalDate birthDate) {
    	this.birth = birthDate.atTime(0, 0, 0);
    }

    Gigasecond(LocalDateTime birthDateTime) {
    	this.birth = birthDateTime;
    }

    LocalDateTime getDateTime() {
    	return this.birth.plusSeconds(1000000000);
    }

}
