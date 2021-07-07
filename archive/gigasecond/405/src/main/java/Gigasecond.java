import java.time.*;
import java.time.temporal.*;

class Gigasecond {
	LocalDateTime date;
    Gigasecond(LocalDate birthDate) {
        date=birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
		date=birthDateTime;
    }

    LocalDateTime getDateTime() {
		return date.plus(1000000000,ChronoUnit.SECONDS);
    }

}
