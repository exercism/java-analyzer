class Hamming {
	
	String leftStrandString;
	String righStrandString;

    Hamming(String leftStrand, String rightStrand) {
    	if(leftStrand.isEmpty() && !rightStrand.isEmpty()) {
    		throw new IllegalArgumentException("left strand must not be empty.");	
		}
		if(!leftStrand.isEmpty() && rightStrand.isEmpty()) {
    		throw new IllegalArgumentException("right strand must not be empty.");	
		}
		if(leftStrand.length() != rightStrand.length()) {
    		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");	
    	}
    	leftStrandString = leftStrand;
    	righStrandString = rightStrand;
    }

    int getHammingDistance() {
    	int hammingDistance =0;
    	
    	for(int index =0; index < leftStrandString.length(); index++) {
    		if(leftStrandString.charAt(index) != righStrandString.charAt(index))
    			hammingDistance++;
    	}
    	return hammingDistance;
    }

}
