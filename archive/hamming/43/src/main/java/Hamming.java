package exercism;

class Hamming {

	String leftStrand;
	String rightStrand;

    Hamming(String leftStrand, String rightStrand) 
    {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() throws IllegalAccessException {
    	if(!leftStrand.equals(rightStrand)) {
    		
    		if(leftStrand.isEmpty()) 
    		{
    			throw new IllegalArgumentException("left starnd must not be empty");
    		}
    		else if(rightStrand.isEmpty()) 
    		{
    			throw new IllegalArgumentException("right starnd must not be empty");
    		}
    		else if(leftStrand.length() > rightStrand.length() ||
    				rightStrand.length() > leftStrand.length()) 
    		{
    			throw new IllegalAccessException("leftStrand and rightStrand must be of equal length.");
    		}
    		else 
    		{
    			int count = 0;
    			for(int i = 0; i < leftStrand.length(); i++) {
    				if(leftStrand.charAt(i) != rightStrand.charAt(i)) {
    					count++;
    				}
    			}
    			return count;
    		}
    	}
    		
		return 0;
    }

}
