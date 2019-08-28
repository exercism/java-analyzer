import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private static final int GIGA_SECOND=1000000000;
    private LocalDate birthDate;
    private LocalDateTime birthDateTime;


    Gigasecond(LocalDate birthDate) {
        this.birthDate=birthDate;
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime=birthDateTime;
    }

    LocalDateTime getDateTime() {
        if(birthDateTime != null)
            return birthDateTime.plusSeconds(GIGA_SECOND);
        return birthDate.atStartOfDay().plusSeconds(GIGA_SECOND);
    }

}
