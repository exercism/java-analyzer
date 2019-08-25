class Hamming {

	private String leftStrand;
	private String rightStrand;

    Hamming(String _leftStrand, String _rightStrand) {
    	if (_leftStrand.length() != _rightStrand.length()) {
        	if (_leftStrand == "" || _leftStrand == null) {
        		throw new IllegalArgumentException("left strand must not be empty.");
        	} else if (_rightStrand == "" || _rightStrand == null) {
        		throw new IllegalArgumentException("right strand must not be empty.");
        	} else {
        		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        	}
        }
    	leftStrand = _leftStrand;
    	rightStrand = _rightStrand;
    }

    int getHammingDistance() {
    	var count = 0;
        for (int i=0; i<leftStrand.length(); i++) {
        	if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
        		count += 1;
        	}
        }
        return count;
    }

}
