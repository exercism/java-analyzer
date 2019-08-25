class Hamming {

    Hamming(String leftStrand, String rightStrand) {
	if(leftStrand.length() == rightStrand.length() ) {
	    s1 = leftStrand;
	    s2 = rightStrand;
	} else {
	    if(leftStrand.length() == 0) throw new IllegalArgumentException("left strand must not be empty.");
	    if(rightStrand.length() == 0) throw new IllegalArgumentException("right strand must not be empty.");
	    if(leftStrand.length() != rightStrand.length()) throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
	}
    }

    int getHammingDistance() {
        int h = 0;
	for(int i=0; i < s1.length(); i++)
	    h += (int) s1.charAt(i) != s2.charAt(i) ? 1:0;
	return h;
    }

    private String s1, s2;
}
