class Hamming {
    char[] leftStrand;
    char[] rightStrand;

    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {
        if (leftStrand.length() == 0 && rightStrand.length() != 0 ) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (rightStrand.length() == 0 && leftStrand.length() != 0 ) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand.toCharArray();
        this.rightStrand = rightStrand.toCharArray();
    }

    int getHammingDistance() {
        int result = 0;
        for (int i = 0; i < leftStrand.length; i++) {
            if (leftStrand[i] != rightStrand[i]) {
                result++;
            }
        }
        return result;
    }
}
