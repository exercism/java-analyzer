class Hamming {

	private static String leftStrand;
	private static String rightStrand;
	private static int strandLength;
	private static int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        
        this.setStrandsLength();
        this.setHammingDistance();
    }

    private void setStrandsLength() {
    	int left = this.leftStrand.length();
    	int right = this.rightStrand.length();
    	String exceptionMessage;

    	if (left != right) {
    		exceptionMessage = "leftStrand and rightStrand must be of equal length.";

        	if (left == 0) {
        		exceptionMessage = "left strand must not be empty.";
        	} else if (right == 0) {
        		exceptionMessage = "right strand must not be empty.";
        	}

        	throw new IllegalArgumentException(exceptionMessage);
        }

        this.strandLength = left;
    }

    private void setHammingDistance() {
    	this.hammingDistance = 0;
    	
    	for (int i = 0; i < this.strandLength; i++) {
    		char leftChar = this.leftStrand.charAt(i);
    		char rightChar = this.rightStrand.charAt(i);

    		if (leftChar != rightChar) {
    			this.hammingDistance++;
    		}
    	}

    }

    int getHammingDistance() {
    	return this.hammingDistance;
    }

}
