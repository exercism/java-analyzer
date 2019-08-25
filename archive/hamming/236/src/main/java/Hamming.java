class Hamming {

	private int hammingDistance = 0;
	private String leftStrand = "";
	private String rightStrand = "";

    Hamming(String leftStrand, String rightStrand) {

    	this.leftStrand = leftStrand;
    	this.rightStrand = rightStrand;
   
       	if (this.leftStrand.length() != this.rightStrand.length()) {

       		if (this.leftStrand.length() == 0) {
	       		throw new IllegalArgumentException("left strand must not be empty.");
	       	} else if (this.rightStrand.length() == 0) {
				throw new IllegalArgumentException("right strand must not be empty.");
	       	} 

       		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
       	}
        
     }

    public int getHammingDistance() {
    	calculateHammingDistance();
        return this.hammingDistance;
    }

    private void calculateHammingDistance() {

    	for (int i = 0; i < this.leftStrand.length(); i++) {
    		if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) {
    			this.hammingDistance++;
    		}
    	}

    }

}
