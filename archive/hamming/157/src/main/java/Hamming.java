class Hamming {
    String leftStrand, rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        String message = "";
        if (leftStrand.length() != rightStrand.length()) {
            message = leftStrand.isEmpty() ? "left strand must not be empty."
                    : rightStrand.isEmpty() ? "right strand must not be empty."
                            : "leftStrand and rightStrand must be of equal length.";
            throw new IllegalArgumentException(message);
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() throws IllegalArgumentException {
        int hammingDistance = 0;

        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                hammingDistance++;
            }
        }
        return hammingDistance;

    }
}
