import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.sound.sampled.SourceDataLine;

class Gigasecond {

    LocalDateTime birthDateTime;
    Gigasecond(LocalDate birthDate) {
        birthDateTime = LocalDateTime.of(birthDate, LocalTime.of(0, 0));
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDateTime() {
        long gigasecond = (long) Math.pow(10, 9);
        long days = gigasecond / (24*3600);
        long hours = gigasecond % (24*3600) / 3600;
        long minutes = gigasecond % (24*3600) % 3600 / 60;
        long seconds = gigasecond % (24*3600) % 3600 % 60;
        System.out.printf("%d-%d-%d-%d\n", gigasecond, days, minutes, seconds);
        return birthDateTime.plusDays(days).plusHours(hours).plusMinutes(minutes).plusSeconds(seconds);
    }

}
