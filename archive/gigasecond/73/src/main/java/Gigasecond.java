import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

class Gigasecond {
	int year;
	Month month;
	int day;
	LocalDateTime input;
	final long gigasec=1000000000L;
//Constructor
    Gigasecond(LocalDate moment) {
        year=moment.getYear();
	month=moment.getMonth();
	day=moment.getDayOfMonth();
	input=LocalDateTime.of(year,month, day,0,0,0);
    }

    Gigasecond(LocalDateTime moment) {
        input=moment;
    }
//method
    LocalDateTime getDateTime() {
	LocalDateTime result= input.plusSeconds(gigasec);
	return result;
	
	
    }

}
