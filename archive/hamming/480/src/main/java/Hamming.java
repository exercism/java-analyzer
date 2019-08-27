class Hamming {
	private String leftStrand;
	private String rightStrand;

    Hamming(String leftStrand, String rightStrand){
		if (leftStrand.length() + rightStrand.length() > 0){
			if (leftStrand.length() == 0){
				throw new IllegalArgumentException ("left strand must not be empty.");
			}	
			if (rightStrand.length() == 0){
				throw new IllegalArgumentException ("right strand must not be empty.");
			}	
			if (leftStrand.length() != rightStrand.length()){
				throw new IllegalArgumentException ("leftStrand and rightStrand must be of equal length.");
			}
		}

		this.leftStrand = leftStrand;
		this.rightStrand = rightStrand;
    }

    public int getHammingDistance(){
		if (leftStrand.equals(rightStrand)){
			return 0;
		} 
   
		int hammingCount = 0;
		for (int i=0; i<=leftStrand.length()-1; i++){
			if(leftStrand.charAt(i) != rightStrand.charAt(i)){
				hammingCount ++;
			}
		}
		return hammingCount;
	}
}
