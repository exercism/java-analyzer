import java.time.LocalDate;
import java.time.LocalDateTime;

//Get dirthdate input
// "plus" 1,000,000,000

class Gigasecond {
	
	LocalDateTime resultTime;
	
    Gigasecond(LocalDate birthDate) {
        resultTime = birthDate.atStartOfDay().plusSeconds( 1000000000 );
    }

    Gigasecond(LocalDateTime birthDateTime) {
	   resultTime = birthDateTime.plusSeconds( 1000000000 );
    }

    LocalDateTime getDateTime() {
		
		return resultTime;
		
    }

}
