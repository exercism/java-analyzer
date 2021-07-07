import java.time.*;

class Gigasecond {

    private LocalDateTime data;

    Gigasecond(LocalDate birthDate) {
       data=LocalDateTime.of(birthDate.getYear(),birthDate.getMonthValue(),birthDate.getDayOfMonth(),0,0);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        data=LocalDateTime.of(birthDateTime.getYear(),birthDateTime.getMonthValue(),birthDateTime.getDayOfMonth(),
                            birthDateTime.getHour(),birthDateTime.getMinute(),birthDateTime.getSecond());
    }

    LocalDateTime getDateTime() {
        data=data.plusSeconds(1000000000);
        return data;
    }

}
