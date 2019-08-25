class Hamming {
    private final String leftStrand;
    private final String rightStrand;
    private final int comparisonLength;

    Hamming(final String leftStrand, final String rightStrand) {
        checkStrandsNotEmpty(leftStrand, rightStrand);
        checkStrandsEqualLength(leftStrand, rightStrand);

        this.comparisonLength = leftStrand.length();
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int hammingDistance = 0;

        if (comparisonLength == 0) {
            return hammingDistance;
        }

        for (int i = 0; i < comparisonLength; i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                hammingDistance++;
            }
        }

        return hammingDistance;
    }

    private void checkStrandsNotEmpty(final String left, final String right) {
        final String lengthExpMessage = "%s strand must not be empty.";

        if (left.length() == right.length()) {
            return;
        }

        if (left.length() == 0) {
            throw new IllegalArgumentException(String.format(lengthExpMessage, "left"));
        }

        if (right.length() == 0) {
            throw new IllegalArgumentException(String.format(lengthExpMessage, "right"));
        }
    }

    private void checkStrandsEqualLength(final String left, final String right) {
        final String strandEqualExpMessage = "leftStrand and rightStrand must be of equal length.";

        if (left.length() != right.length()) {
            throw new IllegalArgumentException(strandEqualExpMessage);
        }
    }

}
