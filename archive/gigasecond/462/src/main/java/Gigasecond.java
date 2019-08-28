package src.main.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Gigasecond {
	
	private LocalDateTime time;

    public Gigasecond(LocalDate birthDate) {
    	this.time = birthDate.atStartOfDay().plusSeconds(getGigasecond());
    }

    public Gigasecond(LocalDateTime birthDateTime) {
    	this.time = birthDateTime.plusSeconds(getGigasecond());
    }

    public LocalDateTime getDateTime() {
    	return this.time;
    }
    
    public long toSeconds() {
    	return this.time.atZone(ZoneId.systemDefault())
    		.toInstant().toEpochMilli();
    }
    
    public static long getGigasecond() {
    	return (long)Math.pow(10, 9);
    }
}
