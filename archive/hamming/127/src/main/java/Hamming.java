class Hamming {

    private String left;
    private String right;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand == null || rightStrand == null) {
            throw new IllegalArgumentException("leftStrand and rightStrand must not be null.");
        }
        if (leftStrand.length() == 0 && rightStrand.length() > 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (rightStrand.length() == 0 && leftStrand.length() > 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        left = leftStrand;
        right = rightStrand;
    }

    int getHammingDistance() {
        char[] lChars = left.toCharArray();
        char[] rChars = right.toCharArray();
        int distance = 0;
        for (int i = 0; i < lChars.length; i++) {
            if (lChars[i] != rChars[i]) {
                distance++;
            }
        }
        return distance;
    }

}
