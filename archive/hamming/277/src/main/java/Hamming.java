class Hamming {
	private String leftString, rightString;

    Hamming(String leftStrand, String rightStrand) {
        int leftLength = leftStrand.length();
        int rightLength = rightStrand.length();

        if (leftLength == rightLength) {
        	leftString = leftStrand;
        	rightString = rightStrand;
        } else if (rightLength == 0) {
        	throw new IllegalArgumentException("right strand must not be empty.");
        } else if (leftLength == 0) {
        	throw new IllegalArgumentException("left strand must not be empty.");
        } else {
        	throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

    }

    int getHammingDistance() {
        int stringLen = leftString.length();

        int difCount = 0;

	    for (int x = 0; x <= stringLen-1; x++) {
	      if (rightString.charAt(x) != leftString.charAt(x)) {
	      	difCount = difCount + 1;
	      }
	    }

	    return difCount;
	    
    }

}

/Users/trevor/Exercism/java/hamming/src/main/java/Hamming.java