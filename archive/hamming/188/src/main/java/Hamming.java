class Hamming {

	private String leftStrand;
	private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
    	this.leftStrand = leftStrand.trim();
    	this.rightStrand = rightStrand.trim();

    	if (this.leftStrand.isEmpty() && !this.rightStrand.isEmpty())
	        throw new IllegalArgumentException("left strand must not be empty.");

    	if (!this.leftStrand.isEmpty() && this.rightStrand.isEmpty())
	        throw new IllegalArgumentException("right strand must not be empty.");

	    if (this.rightStrand.length() != this.leftStrand.length())
	    	throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    int getHammingDistance() {
    	if (this.leftStrand == this.rightStrand)
			return 0;

		int distance = 0;

		// iterate over leftStrand Characters
		// compare leftStrand char at (index) with rightStrand char at (index)
		for (int i = 0; i < this.leftStrand.length(); i++) {
			distance += (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) ? 1 : 0;
		}
		return distance;
    }
    
}
