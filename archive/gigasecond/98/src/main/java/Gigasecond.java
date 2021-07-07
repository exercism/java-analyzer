import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    LocalDateTime main;

    Gigasecond(LocalDate moment) {  //Converts Date to DateTime at 0 hr, 0 min as a converter
        main = moment.atTime(0,0);
    }

    Gigasecond(LocalDateTime moment) { //Equals Converter to Desired DateTime in tests
        main = moment;
    }

    LocalDateTime getDateTime() {   //Mehtod to add a gigasecond to desired DateTime in tests
        return main.plusSeconds(1000000000);
    }
}
