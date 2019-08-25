class Hamming {

    private char[] leftStrandArray;
    private char[] rightStrandArray;


    Hamming(String leftStrand, String rightStrand) {

        if (leftStrand.length() == 0 && rightStrand.length() != 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (rightStrand.length() == 0 && leftStrand.length() != 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        leftStrandArray = leftStrand.toCharArray();
        rightStrandArray = rightStrand.toCharArray();
    }

    int getHammingDistance() {
        int hammingDistance = 0;
        for (int i = 0; i < leftStrandArray.length; i++) {
            hammingDistance += leftStrandArray[i] == (rightStrandArray[i]) ? 0 : 1;
        }
        return hammingDistance;
    }

}
