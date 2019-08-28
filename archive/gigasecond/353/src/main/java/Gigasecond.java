import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
        setBirthDate(birthDate);
    }

    Gigasecond(LocalDateTime birthDateTime) { setBirthDateTime(birthDateTime); }

    //region Setter
    public void setBirthDate(LocalDate birthDate) {
        this.birthDateTime = birthDate.atStartOfDay();
    }

    public void setBirthDateTime(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }
    //endregion

    LocalDateTime getDateTime() {
        return birthDateTime.plusSeconds((long) Math.pow(10,9));
    }

}
