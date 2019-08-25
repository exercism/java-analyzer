class Hamming {
	String leftStrand;
	String rightStrand;
	boolean success=true;
	
    Hamming(String leftStrand, String rightStrand) {
		if (leftStrand.isEmpty()){
			success=false;
			throw new IllegalArgumentException("left strand must not be empty.");		
		}
		if (rightStrand.isEmpty()){
			success=false;
			throw new IllegalArgumentException("right strand must not be empty.");
		}
		if (leftStrand.length()!=rightStrand.length()){
			success=false;
			throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
		}		
	

	if (success==true){
        this.leftStrand=leftStrand;
		this.rightStrand=rightStrand;
		}
    }

    int getHammingDistance() {
		int dist=0;

		if (success){
        try{
			for (int i=0;i<leftStrand.length();i++){
				dist+=(leftStrand.charAt(i)==rightStrand.charAt(i))?0:1;
			}
		}catch(IllegalArgumentException e){
			System.err.println("IllegalArgumentException: " + e.getMessage());
		}catch(StringIndexOutOfBoundsException eo){
			System.err.println("StringIndexOutOfBoundsException: " + eo.getMessage());
		}
		}else{
			throw new IllegalArgumentException("strands must be of equal lengths and not be empty.");
		}
    
			return dist;

	}
}