import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Gigasecond {
	LocalDate birthDate;
	LocalDateTime birthDateTime;
	LocalDateTime modernDateTime;
	
    Gigasecond(LocalDate birthDate) {
        this.birthDate = birthDate;
		modernDateTime = LocalDateTime.of(birthDate.getYear(), birthDate.getMonthValue(), birthDate.getDayOfMonth(), 0, 0, 0);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
		modernDateTime = LocalDateTime.of(birthDateTime.getYear(), birthDateTime.getMonthValue(), birthDateTime.getDayOfMonth(), birthDateTime.getHour(), birthDateTime.getMinute(), birthDateTime.getSecond());
    }

    LocalDateTime getDateTime() {
		modernDateTime = modernDateTime.plus(1000000000, ChronoUnit.SECONDS);
		return modernDateTime;
    }
	
}
