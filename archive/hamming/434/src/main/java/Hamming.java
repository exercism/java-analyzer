class Hamming {

	String left = "";
	String right = "";
	
    Hamming(String leftStrand, String rightStrand) {
    	this.left = leftStrand;
    	this.right = rightStrand;
    }

    int getHammingDistance()  {
    	int counter = 0;
        if(left.length() != right.length()) {
			throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        } else if(left.equals(null)) {
			throw new IllegalArgumentException("left strand must not be empty.");
        }else {
        	for(int i = 0; i < left.length(); i++) {
        		if(left.charAt(i) != right.charAt(i)) {
        			counter++;
        		}
        	}
        }
		return counter;
    }

}
