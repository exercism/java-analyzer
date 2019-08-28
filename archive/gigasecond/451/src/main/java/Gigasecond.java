import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Gigasecond {

	private static final int TOTAL_SECONDS = 1_000_000_000;

	// Total full days in 10 ^ 9 secs
	private static final int TOTAL_DAYS = TOTAL_SECONDS / 86400;

	// Total of seconds that 'left' in days
	private static final int SECONDS_OVER = TOTAL_SECONDS % 86400;

	// 1 hour = 3600 secs so
	private static final int HOURS_OVER = SECONDS_OVER / 3600;

	// minutes over in that hour
	private static final int MINUTES_OVER = (SECONDS_OVER % 3600) / 60;

	// seconds left in that minute
	private static final int SECONDS_OVER_MINUTE = (SECONDS_OVER % 3600) % 60;

	LocalDateTime birthDateTime;

	Gigasecond(LocalDate birthDate) {
		this(LocalDateTime.of(birthDate, LocalTime.of(0, 0, 0)));
	}

	Gigasecond(LocalDateTime birthDateTime) {
		this.birthDateTime = birthDateTime;
	}

	LocalDateTime getDateTime() {
		return birthDateTime.plusDays(TOTAL_DAYS).plusHours(HOURS_OVER).plusMinutes(MINUTES_OVER)
				.plusSeconds(SECONDS_OVER_MINUTE);
	}

}
