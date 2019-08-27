public class Hamming {

	private String leftStrand;
	private String rightStrand;
	private int hammingDistance;
	
    public Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {
    	this.leftStrand = leftStrand;
    	this.rightStrand = rightStrand;
    	checkForIllegalArguments();
    }

    public int getHammingDistance() {
    	for (int i = 0; i < leftStrand.length(); i++) {
    		if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
    			hammingDistance += 1;
    		}
    	}
    	return hammingDistance;
    }
    
    public void checkForIllegalArguments() {
    	if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
    	}
    	else if (!leftStrand.isEmpty() && rightStrand.isEmpty()) {
    		throw new IllegalArgumentException("right strand must not be empty.");
    	}
    	else if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");    		
    	}
    }
}
