import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


class Gigasecond {
	
	LocalDate date1;
	LocalDateTime date2;


	Gigasecond(LocalDate moment) {
   		date1 = moment;
		//need to convert LocalDate to LocalDateTime
		/*
		The main date time classes provide two methods - 1 for formatting, 
		format(DateTimeFormatter formatter) and one for parsing, 
		parse(CharSequence text, DateTimeFormatter formatter)
		DateTimeFormatter allows us to convert by formatting the LocalDate
		into a form which can then be parsed into a LocalDateTime by LocalDate form in the format
		DateTimeformatter formatter = DateTimeFormatter.(formattype)
		LocalDate date = LocalDate.now();
	        String text = date.format(formatter);
  		LocalDateTime parsedDate = LocalDate.parse(text, formatter);
		Using the LocalDate starting string and the DateTimeFormatter format,
		the LocalDateTime parser then creates a LocalDateTime from that string
		in the given format
		*/
		DateTimeFormatter format = DateTimeFormatter.ISO_LOCAL_DATE;
		String text = moment.format(format);		
		LocalDateTime time = LocalDate.parse(text, format).atStartOfDay();
		//atStartofDay combines this parsed date with the time of midnight to create a time of 
		//zero in the localdatetime
		date2 = time;
		
    	}

	Gigasecond(LocalDateTime moment) {
   		date2 = moment;
    	}

	LocalDateTime getDateTime() {
		//any Date has been converted to LocalDateTime, which allows us
		//to simply add the gigasecond, and the LocalDateTime variables are adjusted accordingly
		return date2.plusSeconds(1000000000);
   	 }

}
