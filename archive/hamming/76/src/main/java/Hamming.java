class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {

            if (leftStrand.length() == 0) {
                throw new IllegalArgumentException("left strand must not be empty.");
            }

            if (rightStrand.length() == 0) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }

            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        char[] left = leftStrand.toCharArray();
        char[] right = rightStrand.toCharArray();

        int hammingDistance = 0;

        for (int i = 0; i < left.length; i++) {
            if (left[i] - right[i] != 0) {
                hammingDistance++;
            }
        }

        return hammingDistance;
    }
}
