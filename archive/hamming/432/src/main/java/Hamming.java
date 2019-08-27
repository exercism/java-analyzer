import java.lang.IllegalArgumentException;

class Hamming {

	String left, right = new String();
	int distance = 0;
	
    Hamming(String leftStrand, String rightStrand) {
    	
    	if (leftStrand.isEmpty() && !(rightStrand.isEmpty()))
    			throw new IllegalArgumentException("left strand must not be empty.");
    	
    	if ( !(leftStrand.isEmpty()) && rightStrand.isEmpty())
    			throw new IllegalArgumentException("right strand must not be empty.");
    	
        if (leftStrand.length() != rightStrand.length())
        	throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        
        left = leftStrand;
        right = rightStrand;
    }

    int getHammingDistance() {
        char[] leftArray = left.toCharArray();
        char[] rightArray = right.toCharArray();
        
        int length = leftArray.length;
        for (int i = 0; i < length; i++) {
        	if (leftArray[i] != rightArray[i])
        		distance++;
        }
        
        return distance;
    }
}
