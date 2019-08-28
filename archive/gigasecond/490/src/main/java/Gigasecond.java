import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

class Gigasecond {
	
	LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
		this.birthDateTime = LocalDateTime.of(birthDate, LocalTime.of(0, 0, 0));
    }

    Gigasecond(LocalDateTime birthDateTime) {
		this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
		return this.birthDateTime.plusSeconds((long) Math.pow(10, 9));
    }

}
