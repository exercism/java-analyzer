import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


class Gigasecond {

 private LocalDate localDate;
private LocalDateTime localDateTime;   Gigasecond(LocalDate moment) {

this.localDate = moment;
}

    Gigasecond(LocalDateTime moment) {
this.localDateTime = moment;
}

    LocalDateTime getDateTime() {

LocalDateTime date = null;
LocalDateTime t = null;
if(localDateTime!=null){
t = this.localDateTime;
}
else{
LocalDate sum = this.localDate;
LocalTime time = LocalTime.of(0,0,0);
t = LocalDateTime.of(sum,time);
}
date = t.plusSeconds(1000000000);
return date;
}


}
