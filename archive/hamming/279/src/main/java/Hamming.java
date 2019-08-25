
class Hamming {
	String leftStrand;
	String rightStrand;
	
    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException{
    		this.leftStrand=leftStrand;
    		this.rightStrand=rightStrand;
    		if(leftStrand.length()!=rightStrand.length()) {
        		if(leftStrand.length()==0) {throw new IllegalArgumentException("left strand must not be empty.");}
        		if(rightStrand.length()==0) {throw new IllegalArgumentException("right strand must not be empty.");}
        		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        	}
    }

    int getHammingDistance() {
    	
    	
	    	int counter=0;
			for(int i=0;i<leftStrand.length();i++) {
				if (!(leftStrand.charAt(i)==(rightStrand.charAt(i)))) {
					counter++;
				}
			}
			return counter;
	

}
}
