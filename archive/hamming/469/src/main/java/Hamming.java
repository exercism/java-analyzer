class Hamming {

	private int counter = 0;
	private String leftStrand;
	private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
    	if(leftStrand.length() == 0 && rightStrand.length() > 0) {
    		throw new IllegalArgumentException("left strand must not be empty.");
    	} else if(leftStrand.length() > 0 && rightStrand.length() == 0) {
    		throw new IllegalArgumentException("right strand must not be empty.");
    	} else if(leftStrand.length() != rightStrand.length()) {
    		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    	}
    	this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
    	for(int i = 0; i < leftStrand.length(); i++) {
    		if(leftStrand.charAt(i) != rightStrand.charAt(i)) {
    			counter++;
    		}
    	}
    	return counter;
    }

}
