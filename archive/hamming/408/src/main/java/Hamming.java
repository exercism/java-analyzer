class Hamming {
    private final char[] leftStrand;
    private final char[] rightStrand;
    private final int leftLength;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand.toCharArray();
        this.rightStrand = rightStrand.toCharArray();
        this.leftLength = this.leftStrand.length;
        int rightLength = this.rightStrand.length;

        if (this.leftLength == rightLength) {
            return;
        } else if (this.leftLength == 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightLength == 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        int hammingDistance = 0;

        for (int i = 0; i < leftLength; i++) {
           if (leftStrand[i] != rightStrand[i]) {
               hammingDistance++;
           }
        }

        return hammingDistance;
    }

}
