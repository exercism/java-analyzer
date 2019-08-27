
class Hamming {
	String leftDNA;
	String rightDNA;
    Hamming(String leftStrand, String rightStrand) {
		boolean isBothEmpty = leftStrand.length() == 0 && rightStrand.length() == 0;
		boolean isAnyEmpty = leftStrand.length() == 0 || rightStrand.length() == 0;
		if( isAnyEmpty && !isBothEmpty){
			String exceptionMsg = " strand must not be empty."; 
			String emptyStrand = leftStrand.length() == 0 ? "left" : "right";
			throw new IllegalArgumentException(emptyStrand + exceptionMsg);
		}
		if(leftStrand.length() != rightStrand.length())
			throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
		
        this.leftDNA = leftStrand;
		this.rightDNA = rightStrand;
    }

    int getHammingDistance() {
		int distance=0;
        for(int i=0; i<this.leftDNA.length(); ++i){
			if(this.leftDNA.charAt(i) != this.rightDNA.charAt(i)){
				distance++;
			}
		}
		return distance;
    }
	
}
