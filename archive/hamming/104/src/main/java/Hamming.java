

public class Hamming {
	
	private String leftStrand, rightStrand;
	private int hamCount;

    Hamming(String leftStrand, String rightStrand)
    {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        hamCount = 0;
        
        
    	if (leftStrand.length() != rightStrand.length())
        {
    		if (leftStrand == "" && rightStrand != "")
        	{
            	throw new IllegalArgumentException("left strand must not be empty.");
            } else
        	if (leftStrand != "" && rightStrand == "")
        	{
            	throw new IllegalArgumentException("right strand must not be empty.");
            } else
            {
            	throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }
        }
    }

    int getHammingDistance()
    {
    	if (rightStrand == "" && leftStrand == "")
    	{
    		return 0;
    	}

    	for (int i=0; i<leftStrand.length(); i++)
    	{
    		if (leftStrand.charAt(i) != rightStrand.charAt(i))
    		{
    			hamCount++;
    		}
    	}
    	return hamCount;
    }
}
