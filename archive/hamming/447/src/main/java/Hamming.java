class Hamming {
    private String leftStrand;
    private String rightStrand;

    private int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        // Check for strand length mismatch conditions
        if (leftStrand.length() != rightStrand.length()) {
            // If strand length unequal and one is empty then throw appropriate error
            if (leftStrand.length() == 0)
                throw new IllegalArgumentException("left strand must not be empty.");

            if (rightStrand.length() == 0)
                throw new IllegalArgumentException("right strand must not be empty.");

            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        int hammingCount = 0;

        // Iterate through the strands and calculate the hamming distance
        for (int strIndex = 0; strIndex < leftStrand.length(); strIndex++) {
            if (leftStrand.charAt(strIndex) != rightStrand.charAt(strIndex))
                hammingCount++;
        }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        this.hammingDistance = hammingCount;
    }

    int getHammingDistance() {
        return this.hammingDistance;
    }

    String getLeftStrand() {
        return this.leftStrand;
    }

    String getRightStrand() {
        return this.rightStrand;
    }
}
