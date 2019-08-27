class Hamming {
	String left, right = "";

    Hamming(String leftStrand, String rightStrand) {
    	this.left = leftStrand;
    	this.right = rightStrand;
    	
    	if (this.left.length() != this.right.length()) {
    		if (this.left.isEmpty()) {
    			throw new IllegalArgumentException("left strand must not be empty.");
    		}
        	if (this.right.isEmpty()) {
        		throw new IllegalArgumentException("right strand must not be empty.");
        	}
    		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    		
    	}
    }

    int getHammingDistance() {
		int count = 0;
		for (int i = 0; i < this.left.length(); i++) {
			if (this.left.charAt(i) != this.right.charAt(i)) {
				count++;
			}
		}
		return count;
    }
    
    public static void main(String[] args) {
    	new Hamming("", "G");
    }


}
