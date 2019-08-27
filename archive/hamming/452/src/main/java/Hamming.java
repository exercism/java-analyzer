class Hamming {
	String leftStrand;
	String rightStrand;
	
    Hamming(String leftStrand, String rightStrand) {
    	this.leftStrand = leftStrand;
    	this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
    	if (leftStrand.length() == rightStrand.length()) {
    		int hamming = 0;
    		for (int i = 0; i < leftStrand.length(); i++) {
    			System.out.println(leftStrand.charAt(i) + "=" + rightStrand.charAt(i));
    			if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
    				hamming++;
    			}
    		}
    		return hamming;
    	} else {
    		if (leftStrand.isEmpty()) {
    			throw new IllegalArgumentException("left strand must not be empty.");
    		} else if (rightStrand.isEmpty()) {
    			throw new IllegalArgumentException("right strand must not be empty.");
    		} else {
    			throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    		}
    	}
    }

}
