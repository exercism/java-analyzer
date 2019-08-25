class Hamming {
private int count;
    Hamming(String leftStrand, String rightStrand) {
    	
    	if (leftStrand.length() == 0 && rightStrand.length() != 0) {
    		throw new IllegalArgumentException("left strand must not be empty.");
    	}
    	
    	if (rightStrand.length() == 0 && leftStrand.length() != 0) {
    		throw new IllegalArgumentException("right strand must not be empty.");
    	}

    	if (leftStrand.length() != rightStrand.length()) {
        	throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        
        if (leftStrand.length() == rightStrand.length()) {
        	
        	for(int a = 0;a != leftStrand.length(); a++) {
        		if ((int)leftStrand.charAt(a) != (int)rightStrand.charAt(a)) {
        		count++;
        		}
        	}
        }
    }

    
    
    int getHammingDistance() {
		
        return count;
    }
}
