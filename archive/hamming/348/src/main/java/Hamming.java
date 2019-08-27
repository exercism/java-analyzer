import java.security.InvalidParameterException;

class Hamming {
	String leftStrand;
	String rightStrand;
	 
    Hamming(String leftStrand, String rightStrand) {
    	this.leftStrand=leftStrand;
    	this.rightStrand=rightStrand;
 
    	
    	if (!leftStrand.isBlank() || !rightStrand.isBlank()) {
    		
	    	if (rightStrand.isBlank()) {
				throw new InvalidParameterException("right strand must not be empty.");
	    	}
	    	
	    	if (leftStrand.isBlank()) {
				throw new InvalidParameterException("left strand must not be empty.");
	        }
	    	
	    	if (leftStrand.length() != rightStrand.length() ) {
	        	throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
			}

    	}
  	
    }

    int getHammingDistance() {
    	int hammingDifferenceCounter =0;

		String[] dna_a_Array=toArray(leftStrand);
		String[] dna_b_Array=toArray(rightStrand);
    	
    	
		for (int i=0;i<dna_a_Array.length;i++) {
			if (!dna_a_Array[i].equals(dna_b_Array[i])) {
				hammingDifferenceCounter++;
			}
		}
    		
    	return hammingDifferenceCounter;
    }
    
    
	public static String[] toArray(String dna) {
		String[] dnaArray={};
		dnaArray=dna.split("");
		return dnaArray;
	}

}

