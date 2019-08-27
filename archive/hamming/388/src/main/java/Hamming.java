class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {
        if (leftStrand.length() == 0 && rightStrand.length() != 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (rightStrand.length() == 0 && leftStrand.length() != 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int hammingDistance = 0;
        char[] leftStrandArray = leftStrand.toCharArray();
        char[] rightStrandArray = rightStrand.toCharArray();
        for (int i = 0; i < leftStrandArray.length; i++) {
            if (leftStrandArray[i] != rightStrandArray[i]) {
                hammingDistance++;
            }
        }
        return hammingDistance;
    }

}



