class Hamming {

    private String leftStrand;
	private String rightStrand;

	Hamming(String leftStrand, String rightStrand) {
        
    	this.leftStrand=leftStrand;
    	this.rightStrand=rightStrand;
    	validate();
    	
    }

    private boolean validate() {
    	
    	if(leftStrand.length()==0 && rightStrand.length()==0 ) {return true;}
    	
    	if (leftStrand.length()==0){ throw new IllegalArgumentException("left strand must not be empty.");}
    	
    	if (rightStrand.length()==0){ throw new IllegalArgumentException("right strand must not be empty.");}
    	
    	
    	if (leftStrand.length()!=rightStrand.length()){
    		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");}
    	
    	
    	return true;
    	
    	
	}

	int getHammingDistance() {
        
    	int counter = 0;
    	
    	for (int i=1; i<=leftStrand.length();i++) {
    		
    		if(!leftStrand.substring(i-1, i).equals(rightStrand.substring(i-1, i))) {
    			counter++;
    		}
    		
    	}
    	
    	
    	
    	return counter;
    	
    }
    
    

}
