class Hamming {
	private Integer length;
    Hamming(String leftStrand, String rightStrand) {
		int flag = 0;
    	int leftlen = leftStrand.length();
    	int rightlen = rightStrand.length();
    	if(leftlen == rightlen){
    		if(leftlen == 0){
    			length = 0;
    		}else{
    			for(int i = 0;i < leftlen;leftlen++){
    				if(leftStrand.charAt(i) != rightStrand.charAt(i)){
    					flag++;
    				}
    			}
    			length = flag;
    		}
    	}else{
    		try {
				throw new Exception("leftStrand and rightStrand must be of equal length.");
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
        
    }

    int getHammingDistance() {
        return length;
    }

}
