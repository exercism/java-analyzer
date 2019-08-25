class Hamming {

    private char[] left;
    private char[] right;
    
    Hamming(String leftStrand, String rightStrand) {
        this.left = leftStrand.toCharArray();
        this.right = rightStrand.toCharArray();

	if(left.length == 0 && right.length != 0) {
	    throw new IllegalArgumentException("left strand must not be empty.");
	}

	if(right.length == 0 && left.length != 0) {
	    throw new IllegalArgumentException("right strand must not be empty.");
	}
	
	if(left.length != right.length) {
	    throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
	}

	getHammingDistance();
    }

    int getHammingDistance() {
	int distance = 0;
        for (int i=0; i< left.length; i++) {
	    if (!(left[i] == right[i]))
		distance++;
	}
	return distance;
    }

}
