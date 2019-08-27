class Hamming {
    private String leftStrand;
    private String rightStrand;
    private int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        if (leftStrand.length() != rightStrand.length()) {
            if (leftStrand.isEmpty()) {
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            if (rightStrand.isEmpty()) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.hammingDistance = 0;
    }

    int getHammingDistance() {
        char[] leftArray = leftStrand.toCharArray();
        char[] rightArray = rightStrand.toCharArray();
        for (int i = 0; i < leftArray.length; i++) {
            if (leftArray[i] != rightArray[i]) {
                hammingDistance++;
            }
        }
        return hammingDistance;
    }
}
