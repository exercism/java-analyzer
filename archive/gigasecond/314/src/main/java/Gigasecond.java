import java.time.*;

class Gigasecond {
    Duration duration;
    long epoch;
    LocalDate date;
    Gigasecond(LocalDate birthDate) {
        date = birthDate;
        ZoneId zoneId = ZoneId.systemDefault(); // or: ZoneId.of("Europe/Oslo");
        epoch = date.atStartOfDay(zoneId).toEpochSecond();

    }

    Gigasecond(LocalDateTime birthDateTime) {
        LocalDateTime date = birthDateTime;
        epoch =date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()*1000;
    }

    LocalDateTime getDateTime() {
        Period period = getPeriod(, date);
        duration=new Duration(1000000000,date);
        if (epoch>1000000000)
        {

            //its bigger then 1,000,000 seconds so we do epoch-1,000,000 then get the date he was THAT AGE then get the datetime.
        }
        else if (epoch<1000000000) {
            //its smaller then 1,000,000 seconds so we add to his age the diffrence between 1,000,000-epoch then get the datetime
        }
        else
        {
            //he is 1,000,0000 seconds old.
        }
        return null;
    }
    private static Period getPeriod(LocalDateTime dob, LocalDateTime now) {
        return Period.between(dob.toLocalDate(), now.toLocalDate());
    }
}
