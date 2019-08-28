import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

class Gigasecond {

	private static final long GIGASECOND = (long) Math.pow(10, 12);
	private static final String UTC = "UTC";
	private LocalDateTime dateTime;

	Gigasecond(LocalDate birthDate) {
		long milliseconds = birthDate.atStartOfDay().atZone(ZoneId.of(UTC)).toInstant().toEpochMilli();
		setDateTime(addGigasecond(milliseconds));
	}

	Gigasecond(LocalDateTime birthDateTime) {
		long milliseconds = birthDateTime.atZone(ZoneId.of(UTC)).toInstant().toEpochMilli();
		setDateTime(addGigasecond(milliseconds));
	}

	LocalDateTime getDateTime() {
		return dateTime;
	}

	private long addGigasecond(long time) {
		return time + GIGASECOND;
	}

	private void setDateTime(long time) {
		dateTime = Instant.ofEpochMilli(time).atZone(ZoneId.of(UTC)).toLocalDateTime();
	}

}
