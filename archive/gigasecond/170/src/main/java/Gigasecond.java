import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * 
 * Given a moment, determine the moment that would be after a gigasecond
 * has passed. A gigasecond is 10^9 (1,000,000,000) seconds.
 *
 */
public class Gigasecond {
	
	private long oneGig = 1000000000L;
	private LocalDateTime localDT;
	// Which time zone used is irrelevant when it is the same used to convert back and forth
  	ZoneOffset zoneOffSet = ZoneOffset.UTC;

    /**
     * Set date to add from in LocalDate format
     * @param moment LocalDate (without time)
     */
  	public Gigasecond(LocalDate moment) {
  		// Convert to LocalDateTime by defining start of day time
    	localDT = moment.atStartOfDay();
    }

    /**
     * Set date and time to add from in LocalDateTime format
     * @param moment LocalDateTime (includes time)
     */
   public Gigasecond(LocalDateTime moment) {
    	localDT = moment;
    }

   /**
    * Obtain the date and time after adding a gigasecond
    * @return result date and time
    */
   public LocalDateTime getDateTime() {
    	// Convert to Instant (in java time line) to simplify code
      	Instant localInstant = localDT.toInstant(zoneOffSet);
      	Instant futureInstant = localInstant.plusSeconds(oneGig);

    	return LocalDateTime.ofInstant(futureInstant, zoneOffSet);
    }

}
