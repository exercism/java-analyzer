class Hamming {

    private char[] leftStrand;
    private char[] rightStrand;

    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {
        if (isNullOrEmpty(leftStrand) ^ isNullOrEmpty(rightStrand)) {
            if (isNullOrEmpty(leftStrand)) {
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            if (isNullOrEmpty(rightStrand)) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand.toCharArray();
        this.rightStrand = rightStrand.toCharArray();
    }

    int getHammingDistance() {
        int hammingDistance = 0;
        for (int i = 0; i < leftStrand.length; i++) {
            hammingDistance += leftStrand[i] == rightStrand[i] ? 0 : 1;
        }
        return hammingDistance;
    }

    boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

}
