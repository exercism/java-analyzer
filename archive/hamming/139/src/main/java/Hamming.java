import java.util.Scanner;

class Hamming 
{
	String DNA="";
	String DNA2="";
	int count=0;
	
	public static void main(String[] args) 
	{
		System.out.println("Hamming Problem");
		String DNA="";
		String DNA2="";
		Scanner s =new Scanner(System.in);
			System.out.println("Enter the First DNA ");
		DNA=s.nextLine();
			System.out.println("Enter the Second DNA");
		DNA2=s.nextLine();
		
		Hamming obj=new Hamming(DNA,DNA2);
		int result=obj.getHammingDistance();
		System.out.println(result);
	}

    Hamming(String leftStrand, String rightStrand) 
    {
    	if(leftStrand.length()!=rightStrand.length())
    	{
    		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    	}
    	 	
    	
    }
        


    int getHammingDistance() 
    {
    	
    	String UDNA=DNA.toUpperCase();
    	String UDNA2=DNA2.toUpperCase();
    	
        for(int i=0;i<UDNA.length();i++)
        {
        	if(UDNA.charAt(i)!=UDNA2.charAt(i))
        	{
           count++;
        	}
        }
        return count;
    }

}


