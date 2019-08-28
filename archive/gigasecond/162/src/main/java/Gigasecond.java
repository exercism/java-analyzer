import java.security.Timestamp;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;




class Gigasecond {

    static long time = (long) Math.pow(10, 9) * 1000;

    public static void main(String[] args) {
        Time ts = new Time(time);
        System.out.println(ts);
    }

    Gigasecond(LocalDate moment) {
        
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    Gigasecond(LocalDateTime moment) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    LocalDateTime getDateTime() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}
