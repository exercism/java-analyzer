import java.lang.IllegalArgumentException;

class Hamming {
    
    final String leftStrand, rightStrand;

    Hamming(String leftStrand, String rightStrand) {
	    if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
		throw new java.lang.IllegalArgumentException("left strand must not be empty.");
	    }

	    if (!leftStrand.isEmpty() && rightStrand.isEmpty()) {
		throw new java.lang.IllegalArgumentException("right strand must not be empty.");
	    }

	    if (leftStrand.length() != rightStrand.length()) {
		throw new java.lang.IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
	    } 

	    this.leftStrand = leftStrand;
	    this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
	    int distance = 0;
	    for (int pos = 0; pos < leftStrand.length(); pos++) {
		    if (leftStrand.charAt(pos) != rightStrand.charAt(pos)) {
			    distance++;
		    }
	    }
	    return distance;
    }

}
