class Hamming {

	private String leftStrand;
	private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {

    	if (leftStrand.isEmpty() && !rightStrand.isEmpty())
    		throw new IllegalArgumentException("left strand must not be empty.");

	    if (rightStrand.isEmpty() && !leftStrand.isEmpty())
		    throw new IllegalArgumentException("right strand must not be empty.");

	    if (leftStrand.length() != rightStrand.length())
	    	throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

	    this.leftStrand = leftStrand;
	    this.rightStrand = rightStrand;
    }

    int getHammingDistance() {

	    int distance = 0;

	    for (int i = 0; i < leftStrand.length(); i++) {

		    char left = leftStrand.charAt(i);
		    char right = rightStrand.charAt(i);

		    if (left != right)
			    distance++;
	    }

	    return distance;
    }
}
