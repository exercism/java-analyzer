import java.time.LocalDate;

import java.time.LocalDateTime;

class Gigasecond {

	private LocalDateTime localDateTime;

	Gigasecond(LocalDate birthDate) {

		//throw new UnsupportedOperationException("Delete this statement and write your own implementation.")
		localDateTime = LocalDateTime.of(birthDate.getYear(),birthDate.getMonthValue(),birthDate.getDayOfMonth(),0,0,0);
		localDateTime = localDateTime.plusSeconds(1000000000);

	}

	Gigasecond(LocalDateTime birthDateTime) {

		//throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
		localDateTime = LocalDateTime.of(birthDateTime.getYear(),birthDateTime.getMonthValue(),birthDateTime.getDayOfMonth(),birthDateTime.getHour(),birthDateTime.getMinute(),birthDateTime.getSecond());
		localDateTime = localDateTime.plusSeconds(1000000000);

	}

	LocalDateTime getDateTime() {

		//throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
		return localDateTime;

	}
}