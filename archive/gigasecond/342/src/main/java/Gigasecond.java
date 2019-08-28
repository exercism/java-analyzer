import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
	
	private static final Long GIGASECOND_IN_SECONDS = 1_000_000_000L;
	
	private LocalDateTime birthDateTime;

    public Gigasecond(LocalDate birthDate) {
    	this(birthDate.atStartOfDay());
    }

    public Gigasecond(LocalDateTime birthDateTime) {
    	this.birthDateTime = birthDateTime;
    }

    public LocalDateTime getDateTime() {
        return birthDateTime.plusSeconds(GIGASECOND_IN_SECONDS);
    }

}
