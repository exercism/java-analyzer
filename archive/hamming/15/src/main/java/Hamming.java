class Hamming {

    private String left;
    private String right;
    private int strandLength;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() == rightStrand.length()) {
            left = leftStrand;
            right = rightStrand;
            strandLength = leftStrand.length();
        } else {
            if (leftStrand.length() == 0) {
                throw new IllegalArgumentException("left strand must not be empty.");
            } else if (rightStrand.length() == 0) {
                throw new IllegalArgumentException("right strand must not be empty.");
            } else {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }
        }
    }

    int getHammingDistance() {
        int counter = 0;
        for (int i = 0; i < strandLength; i++) {
            if (left.charAt(i) != right.charAt(i)) {
				counter++;
			}
        }
        return counter;   
    }
}
