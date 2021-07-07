import java.time.LocalDate;
import java.util.Scanner;
import java.time.LocalDateTime;

class Gigasecond 
{
	static LocalDateTime dateTime;
    public static void main(String args[])
    {
    	Gigasecond obj;
    	Scanner scan=new Scanner(System.in);
    	System.out.println("Press 1 for Date only and 0 for Date and Time");
    	int n=scan.nextInt();
    	if(n==1)
    	{
    	LocalDate date=LocalDate.now();
    	System.out.println("DATE" + date);
    	 obj=new Gigasecond(date);
    	}
    	else
    	{
    		LocalDateTime time=LocalDateTime.now();
            System.out.println("TIME"+time);
            obj=new Gigasecond(time);
    	}
        LocalDateTime result=obj.getDateTime();
        System.out.println("The Time to Live is"+result);
    }

            

   
Gigasecond(LocalDate moment) 
{
	dateTime = moment.atTime(0,0);
        
}

    Gigasecond(LocalDateTime moment) 
    {
       dateTime=moment; 
    }

    LocalDateTime getDateTime() 
    {
    	return dateTime.plusSeconds(1000000000);
    }

}

