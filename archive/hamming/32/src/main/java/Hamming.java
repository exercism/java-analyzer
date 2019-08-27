class Hamming {
	int distance;
	
    Hamming(String leftStrand, String rightStrand) {
    	distance = 0;

    	if(leftStrand.length() != rightStrand.length()) {
         	if(leftStrand.trim().length() == 0)
        		throw new IllegalArgumentException("left strand must not be empty.");
        	if(rightStrand.trim().length() == 0)
        		throw new IllegalArgumentException("right strand must not be empty.");
    	
       		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    	}

    	for (int i = 0; i < leftStrand.length(); i++) {
			distance += leftStrand.charAt(i) != rightStrand.charAt(i) ? 1 : 0;
		}
    }

    int getHammingDistance() {
    	return distance;
    }

}
