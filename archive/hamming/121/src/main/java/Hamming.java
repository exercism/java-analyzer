class Hamming {
	String LS, RS;
    
    Hamming(String leftStrand, String rightStrand) {
        LS = leftStrand;
        RS = rightStrand;
        
        if(LS.length()==0 && RS.length()!=0)
        	throw new IllegalArgumentException("left strand must not be empty.");
        else if(LS.length()!=0 && RS.length()==0)
        	throw new IllegalArgumentException("right strand must not be empty.");
        
       	if(LS.length()!=RS.length()) {
           	throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        
        	int c = 0;
        	for(int i = 0; i <LS.length(); i++) {
        		if(LS.charAt(i)!=RS.charAt(i))c+=1;
        	}
        	return c;
        
    }

}
