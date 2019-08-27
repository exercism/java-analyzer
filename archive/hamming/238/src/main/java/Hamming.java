class Hamming {

    Hamming(String leftStrand, String rightStrand) {
    	if (leftStrand.length() != rightStrand.length()) {
        	if ("".equals(leftStrand)) {
        		throw new IllegalArgumentException("left strand must not be empty.");
        	}
        	if ("".equals(rightStrand)) {
        		throw new IllegalArgumentException("right strand must not be empty.");
        	}
    		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    	}
    	
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
    	int cnt = 0;
    	for (int i = 0; i < leftStrand.length(); i++) {
    		if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
    			cnt++;
    		}
    	}
    	return cnt;
    }

    private String leftStrand;
    private String rightStrand;
}
