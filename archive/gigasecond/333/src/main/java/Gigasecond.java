import java.time.*;

class Gigasecond {

    private LocalDateTime gigatime;
    private static long gigaseconds = 1000000000L;

     Gigasecond (LocalDate birthDate) {

        this.gigatime = birthDate.atStartOfDay();

    }

    Gigasecond(LocalDateTime birthDateTime) {

       this.gigatime = birthDateTime;
    }

    LocalDateTime getDateTime() {

       return gigatime.plusSeconds(gigaseconds);
    }

}
