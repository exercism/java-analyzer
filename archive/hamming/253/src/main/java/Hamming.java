class Hamming {

    String left;
    String right;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.isBlank() && !rightStrand.isBlank()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (!leftStrand.isBlank() && rightStrand.isBlank()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.left = leftStrand;
        this.right = rightStrand;
    }

    int getHammingDistance() {
        if (left.isBlank() && right.isBlank()) {
            return 0;
        }
        int hammingDistance = 0;
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) != right.charAt(i)) {
                hammingDistance++;
            }
        }
        return hammingDistance;
    }

}
