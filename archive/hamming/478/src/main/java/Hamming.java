class Hamming {

    private final String leftStrand;
    private final String rightStrand;

    Hamming(final String leftStrand, final String rightStrand) {
        final String leftStrandTrimmed = leftStrand.trim();
        final String rightStrandTrimmed = rightStrand.trim();

        if (leftStrandTrimmed.isEmpty() && !rightStrandTrimmed.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (rightStrandTrimmed.isEmpty() && !leftStrandTrimmed.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftStrandTrimmed.length() != rightStrandTrimmed.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }


        this.leftStrand = leftStrandTrimmed;
        this.rightStrand = rightStrandTrimmed;
    }

    int getHammingDistance() {
        final int strandLength = leftStrand.length();
        int hammingDistance = 0;

        for (int i = 0; i < strandLength; i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                hammingDistance++;
            }
        }

        return hammingDistance;
    }

}
