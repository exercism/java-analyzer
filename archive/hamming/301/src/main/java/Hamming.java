class Hamming {
	String left;
	String right;
    Hamming(String leftStrand, String rightStrand) {

    	this.left = leftStrand;
    	this.right = rightStrand;
    	
    }

    int getHammingDistance(){
    	
   
    		try {
    			if(left.length()!=right.length()) {
    		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    			}
    		}catch(Exception e) {
    			System.out.print("leftStrand and rightStrand must be of equal length.");
    		} 
    		
    	
    	
    	int count = 0;
    	
    	for(int i = 0; i< left.length();i++) {
    		if(left.charAt(i)!=right.charAt(i)) {
    			count++;
    		}
    	}
        return count;
    }

}
