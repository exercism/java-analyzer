class Hamming {
	private String left;
	private String right;

    Hamming(String leftStrand, String rightStrand) {
    	
    	if(leftStrand.isEmpty() && rightStrand.isEmpty() ) {
    		//I don't think this is good style, but I don't know how to catch that other way.
    		//NO-OP
    	}
    	
    else if(leftStrand.isEmpty()) {
    		throw new IllegalArgumentException("left strand must not be empty.");	
    	}
    	
    	else if(rightStrand.isEmpty()) {
    		throw new IllegalArgumentException("right strand must not be empty.");	
    	}
    	
    	else if(leftStrand.length() != rightStrand.length()) {
    		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    	}
    	
    	
    	
        this.left = leftStrand;
        this.right = rightStrand;
    }

    int getHammingDistance() {
    	int d = 0;
        for(int i = 0; i < left.length(); i++) {
        	if(left.charAt(i) != right.charAt(i)) {
        		d++;
        	}
        }
        return d;
    }

}
