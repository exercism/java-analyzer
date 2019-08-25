/**
 * 
 * Creates an object with a single method to compute the
 * hamming distance between two DNA strands (strings)
 * 
 * 
 */
public class Hamming {
	
	private String lStrand, rStrand;

    /**
     * Sets the two DNA strands (strings) to be compared to measure it's
     * hamming distance
     * <br>
     * The Hamming distance is only defined for sequences of equal length,
     * so an attempt to calculate it between sequences of different lengths
     * will throw an IllegalArgumentException error
     * 
     * @param leftStrand First DNA strand
     * @param rightStrand Second DNA strand
     */
	public Hamming(String leftStrand, String rightStrand) {
    	if (leftStrand.length() == rightStrand.length()) {
    		lStrand = leftStrand;
    		rStrand = rightStrand;
    	} else if (leftStrand.length() == 0) {
    		throw new IllegalArgumentException("left strand must not be empty.");
    	} else if (rightStrand.length() == 0) {
    		throw new IllegalArgumentException("right strand must not be empty.");
    	} else
    		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    /**
     * Compute the Hamming distance between leftStrand and rightStrand
     * <br>
     * We read DNA using the letters C,A,G and T. Two strands might look like this:
     * <br>
     * <pre>
     * GAGCCTACTAACGGGAT
     * CATCGTAATGACGGCCT
     * ^ ^ ^  ^ ^    ^^
     *</pre>
     * They have 7 differences, and therefore the Hamming Distance is 7.
     * @return The hamming distance
     */
	public int getHammingDistance() {
    	int dist = 0;
    	
    	for (int i=0; i<lStrand.length(); i++) {
    		if (lStrand.charAt(i) != rStrand.charAt(i)) {
    			dist++;
    		}
    	}
    	
    	return dist;
    }

}
