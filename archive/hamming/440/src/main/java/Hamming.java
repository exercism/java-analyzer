class Hamming {
	String leftStrand;
	String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }


    int getHammingDistance() {
    	if (leftStrand.length() != rightStrand.length()) {
    		String message = "";
    		if (leftStrand.length() == 0) {
    			message = "left strand must not be empty.";
    		}
    		else {
	    		if (rightStrand.length() == 0) {
	    			message = "right strand must not be empty.";
	    		}
	    		else {
	    			message = "leftStrand and rightStrand must be of equal length.";
	    		}
    		}
    		throw new IllegalArgumentException(message);
    	}
    	if (leftStrand == null && rightStrand == null) { return 0;}
    	int tot = 0;
        char[] left = leftStrand.toCharArray();
        char[] right = rightStrand.toCharArray();
        for (int i = 0; i < left.length; i++) {
        	if (left[i] != right[i]) {
        		tot++;
        	}
        }
        return tot;
    }
    
   

}
