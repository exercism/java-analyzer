class Hamming {

	int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand == null || leftStrand.isEmpty())
    	{
    		if(rightStrand != null && !rightStrand.isEmpty())
    		{
    			throw new IllegalArgumentException("left strand must not be empty.");
    		}
    	}
    	else
    	{
    		if(rightStrand == null || rightStrand.isEmpty())
    		{
    			throw new IllegalArgumentException("right strand must not be empty.");
    		}
    	}
    	if(leftStrand.length() != rightStrand.length())
        {
        	throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

    	hammingDistance = 0;
        for(int i = 0; i < leftStrand.length(); ++i)
        {
        	if(leftStrand.charAt(i) != rightStrand.charAt(i))
        	{
        		++hammingDistance;
        	}

        }
    }

    int getHammingDistance() {
    	return hammingDistance;
    }

}
