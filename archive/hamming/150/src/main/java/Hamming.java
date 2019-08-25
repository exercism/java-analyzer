class Hamming {
	String left="";
	String right="";
	int len;
	

    Hamming(String leftStrand, String rightStrand) {
        	
        	if(leftStrand.length()!=rightStrand.length()){
			
			if(leftStrand.equals("")){
        			throw new IllegalArgumentException("left strand must not be empty.");
        		}
        
        		if(rightStrand.equals("")){
        			throw new IllegalArgumentException("right strand must not be empty.");
        		}
        		
        		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        	}
        	
        	this.left=leftStrand;
        	this.right=rightStrand;
        	this.len=left.length();	
    }
      	

    int getHammingDistance() {
        
        int dist=0;
             if(!(len==0)){
             	for(int i=0;i<len;i++){
             		if(left.charAt(i)!=right.charAt(i)){
             			dist++;
             		}
             	}
             }
        
        return dist;
    }

}

