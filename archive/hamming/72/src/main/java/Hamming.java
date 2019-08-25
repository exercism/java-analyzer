class Hamming {

    private String leftStrand = null;
    private String rightStrand = null;

    Hamming(String leftStrand, String rightStrand) {

        if (leftStrand == null || rightStrand == null) {
            throw new IllegalArgumentException("left strand and right strand must not be null");
        }

        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException(("left strand must not be empty."));
        }

        if (rightStrand.isEmpty() && !leftStrand.isEmpty()) {
            throw new IllegalArgumentException(("right strand must not be empty."));
        }

        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int hammingDistance = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            hammingDistance = leftStrand.charAt(i) == rightStrand.charAt(i) ? hammingDistance : hammingDistance + 1;
        }
        return hammingDistance;
    }
}
