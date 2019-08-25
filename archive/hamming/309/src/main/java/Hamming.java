import com.google.common.collect.Streams;

class Hamming {

	private String left;
	private String right;
	
    Hamming(String leftStrand, String rightStrand) {
    	if(leftStrand.length() != rightStrand.length()) {
    		var errorString = "leftStrand and rightStrand must be of equal length.";
			if(leftStrand.length() == 0) {
				errorString = "left strand must not be empty.";
			}
			if(rightStrand.length() == 0) {
				errorString = "right strand must not be empty.";
			}
			throw new IllegalArgumentException(errorString);
    	}
        left = leftStrand;
        right = rightStrand;
    }

    int getHammingDistance() {
        return Streams
        		.zip(
        				left.chars().mapToObj(c -> (Integer)c),
        				right.chars().mapToObj(c -> (Integer)c),
        				(l, r) -> (l == r) ? 0 : 1)
        		.mapToInt(Integer::intValue)
        		.sum();
    }

}
