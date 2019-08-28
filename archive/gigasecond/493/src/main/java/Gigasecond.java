import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

class Gigasecond {
	private LocalDateTime birth;
	private long GIGASECOND = 1000000000;

	Gigasecond(LocalDate birthDate) {
		birth = birthDate.atStartOfDay();
	}

	Gigasecond(LocalDateTime birthDateTime) {
		this.birth = birthDateTime;
	}

	LocalDateTime getDateTime() {
		return Instant.ofEpochMilli(birth.atZone(ZoneId.of("UTC")).toEpochSecond() + GIGASECOND * 1000).atZone(ZoneId.of("UTC")).toLocalDateTime();
	}

}
