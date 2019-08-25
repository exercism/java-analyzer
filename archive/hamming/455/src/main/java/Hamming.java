class Hamming {
	String leftStrand;
	String rightStrand;
	
    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
        	if (leftStrand.isEmpty()) {
        		throw new IllegalArgumentException("left strand must not be empty.");
       		} else if (rightStrand.isEmpty()) {
        		throw new IllegalArgumentException("right strand must not be empty.");
        	}
        	throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        } else {
        	this.leftStrand = leftStrand;
        	this.rightStrand = rightStrand;
        }
    }

    int getHammingDistance() {
        int distance = 0;
        for (int i = 0; i < this.leftStrand.length(); i++) {
        	if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) {
        		distance++;
        	}
        }
        return distance;
    }

}
