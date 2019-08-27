import org.apache.commons.lang3.StringUtils;

class Hamming {

	private String leftStrand;
	private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if(StringUtils.isBlank(leftStrand) && StringUtils.isNotBlank(rightStrand)) {
        	throw new IllegalArgumentException("left strand must not be empty.");
        }

        if(StringUtils.isBlank(rightStrand) && StringUtils.isNotBlank(leftStrand)) {
        	throw new IllegalArgumentException("right strand must not be empty.");
        }

        if(leftStrand.length() != rightStrand.length()) {
        	throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
    	int hammingDistance = 0;
    	for(int i=0; i<leftStrand.length(); i++) {
    		hammingDistance += (leftStrand.charAt(i) == rightStrand.charAt(i) ? 0 : 1);
    	}
    	return hammingDistance;
    }
}
