import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

	private final long gigasecond = 1_000_000_000;

	private static int MINUTE = 60;
	private static int HOUR = MINUTE * 60;
	private static int DAY = HOUR * 24;

	private LocalDate brithDate = null;
	private LocalDateTime birthDateTime = null;

	Gigasecond(LocalDate birthDate) {
		this.brithDate = birthDate;
	}

	Gigasecond(LocalDateTime birthDateTime) {
		this.birthDateTime = birthDateTime;
	}

	LocalDateTime getDateTime() {
		if (brithDate != null) {
			long day = gigasecond / DAY;
			long rest = gigasecond % DAY;

			int hour = (int) (rest / HOUR);
			int minute = (int) (rest % HOUR) / MINUTE;
			int scoend = (int) ((rest % HOUR) % MINUTE);

			return LocalDateTime.of(brithDate.plusDays(day), LocalTime.of(hour, minute, scoend));
		}
		if (birthDateTime != null)
			return birthDateTime.plusSeconds(gigasecond);
		return LocalDateTime.now();
	}

}
