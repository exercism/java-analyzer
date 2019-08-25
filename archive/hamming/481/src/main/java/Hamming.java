class Hamming {
	
	String leftstr = "";
	String rightstr = "";

	Hamming(String leftStrand, String rightStrand) {

		if (leftStrand == "" && rightStrand != "") {  
			throw new IllegalArgumentException("left strand must not be empty.");
		}
		if (rightStrand == ""&& leftStrand != "") {  
			throw new IllegalArgumentException("right strand must not be empty.");
		}
        if  (leftStrand.length() != rightStrand.length()) {  
			throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
		}
        leftstr = leftStrand;
        rightstr = rightStrand;
        
    }
	
    int getHammingDistance() {
    	
    	if  (leftstr == "" && rightstr == "") 
    		return(0);
    	
    	int j = 0 ;
    	char[] lArr = leftstr.toCharArray();
    	char[] rArr = rightstr.toCharArray();
    	for (int i=0; i<lArr.length; i++) {
    		if (lArr[i] != rArr[i])
    			j++;
    	}
    	return(j);
    }

}
