class Hamming {

    private int hammingDistance = 0;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand.isEmpty() && !leftStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        for (int i = 0; i < leftStrand.length(); i++) {
            hammingDistance += leftStrand.charAt(i) == rightStrand.charAt(i) ? 0 : 1;
        }
    }

    int getHammingDistance() {
        return hammingDistance;
    }

}
