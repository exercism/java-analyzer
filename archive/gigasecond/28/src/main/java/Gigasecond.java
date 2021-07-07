import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
	
	


private LocalDateTime moment;


    public Gigasecond(LocalDate moment) {
        this.moment=(moment.atTime(0,0));            	    	
    }

    

	public Gigasecond(LocalDateTime moment) {
        this.moment=moment;
    }

    
    public LocalDateTime getDateTime() {    	
    	return addGiga();        
    }
    
    private LocalDateTime addGiga() {    			
    	Number giga=(int)Math.pow(10.0, 9.0);
    	return moment.plusSeconds(giga.longValue());
	}

}
