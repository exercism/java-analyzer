class Hamming {
	private String leftStrand;
	private String rightStrand;
	
    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        
        if(leftStrand.isEmpty() && rightStrand.isEmpty()) {
        	// valid scenario 
        	
        }
        else if(leftStrand.isEmpty())
        	throw new IllegalArgumentException("left strand must not be empty.");
        else if(rightStrand.isEmpty())
        	throw new IllegalArgumentException("right strand must not be empty.");
        else if(leftStrand.length() != rightStrand.length())
        	throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

    }

    int getHammingDistance() {
    	int diffCount = 0;
    	int i = 0;
    	
    	if(leftStrand.equals(rightStrand)) return 0;
    	
//    	leftStrand.chars().filter(e -> {
//    		return e == rightStrand.charAt(i++);
//    	});
    	
    	for(char a : leftStrand.toCharArray()) {
    		diffCount += a != rightStrand.charAt(i++) ? 1 : 0;
    	}
    	
        return diffCount;
    }

}
