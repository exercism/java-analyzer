class Hamming {

	private String leftStrand;
	private String rightStrand;

	private int strandLength;
	private int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
		this.leftStrand = leftStrand;
		this.rightStrand = rightStrand;

		int leftLength = leftStrand.length();
		int rightLength = rightStrand.length();

		if ( leftLength == rightLength ) {
			this.strandLength = leftLength;
		} else {
			if ( leftStrand.isEmpty() ) {
        		throw new IllegalArgumentException("left strand must not be empty.");
			} else if ( rightStrand.isEmpty() ) {
        		throw new IllegalArgumentException("right strand must not be empty.");
			} else {
				throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
			}
		}
    }

    int getHammingDistance() {
		hammingDistance = 0;

		// Test character by character and count mismatches
		for ( int i = 0; i < strandLength; i++ ) {
			int leftChar  = (int)leftStrand.charAt(i);
			int rightChar = (int)rightStrand.charAt(i);

			if ( leftChar != rightChar ) {
				hammingDistance++;
			}
		}

		return hammingDistance;
    }

}
