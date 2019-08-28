import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {
	
	private LocalDateTime birthTime;

    Gigasecond(LocalDate birthDate) {
    	birthTime = LocalDateTime.of(birthDate, LocalTime.ofSecondOfDay(0));
    }

    Gigasecond(LocalDateTime birthDateTime) {
    	birthTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
    	return birthTime.plusSeconds((long) Math.pow(10, 9));
    }

}
