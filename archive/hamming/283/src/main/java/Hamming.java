import java.util.stream.IntStream;

class Hamming {

    private String right;
	private String left;

	Hamming(String leftStrand, String rightStrand) {
        left = leftStrand;
        right = rightStrand;
        
        if (left.length() != right.length()) {
        	 if (left.isEmpty()) {
        	    throw new IllegalArgumentException("left strand must not be empty.");
	        }
	        else if (right.isEmpty()  ) {
	        	throw new IllegalArgumentException("right strand must not be empty.");
	        }
        	 
        	throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
    	if (left.isEmpty() && right.isEmpty()) {
    		return 0;
    	}
    	else {
    		return IntStream.range(0,  left.length())
        	.reduce(0, (acc,i) ->  (left.codePointAt(i) != right.codePointAt(i)) ? acc + 1 : acc);
    	}
    	
    }
   
    
    public static void main(String[] args) {
    	Hamming ham  = new Hamming("G", "T");
    	System.out.println(ham.getHammingDistance());
    }
}
