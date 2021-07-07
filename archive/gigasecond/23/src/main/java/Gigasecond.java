import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private  LocalDate moment1;
    private  LocalDateTime moment2;
    Gigasecond(LocalDate moment1) {
        this.moment1=moment1;
    }

    Gigasecond(LocalDateTime moment2) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    LocalDateTime getDateTime() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}
