class Hamming {
	private String leftStrand, rightStrand;
	private int length;
	private boolean dirtyCache = true; // dirty cache flag
	private int hammingDistance = 0; // hamming distance cache

    public Hamming(String leftStrand, String rightStrand) {
		this.length = leftStrand.length();
		if (this.length != rightStrand.length()) {
			if (this.length == 0)
				throw new IllegalArgumentException("left strand must not be empty.");
			else if (rightStrand.length() == 0)
				throw new IllegalArgumentException("right strand must not be empty.");
        	throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
		}
		this.leftStrand = leftStrand;
		this.rightStrand = rightStrand;
    }

    public int getHammingDistance() {
		if (this.dirtyCache) { // compute only as needed. (check cache flag)
			for (int i = 0; i < length; i++)
				if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i))
					this.hammingDistance++;
			this.dirtyCache = false; // set flag if computed.
		}
		return this.hammingDistance;
    }

}
