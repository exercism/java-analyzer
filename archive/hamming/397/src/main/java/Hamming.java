class Hamming {
	
	String leftStrand, rightStrand;

    Hamming(String leftStrand, String rightStrand) throw IllegalArgumentException(leftStrand.length()!=rightStrand.length()){
        this.leftStrand=leftStrand;
        this.rightStrand=rightStrand;
    }

    int getHammingDistance() {
        
    	for(int i=0; i<leftStrand.length(); i++) {
    		int cnt=0;  //counter for differences 
    		
    		if(leftStrand[i]!=rightStrand[i]) {  //if there is is difference between the two Strings, increment cnt
    			cnt++;
    		}
    	}
    	
    	return cnt;
    }

}
