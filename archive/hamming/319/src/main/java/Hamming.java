class Hamming {

    private int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        checkArgument(
                leftStrand.isEmpty() == rightStrand.isEmpty(),
                String.format("%s strand must not be empty.", leftStrand.isEmpty() ? "left" : "right"));
        checkArgument(
                leftStrand.length() == rightStrand.length(),
                "leftStrand and rightStrand must be of equal length.");

        // Initialize the hamming distance once since it never changes
        this.hammingDistance = calculateHammingDistance(leftStrand, rightStrand);
    }

    int getHammingDistance() {
        return hammingDistance;
    }

    private void checkArgument(boolean condition, String errorMessage) {
        if (!condition) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private int calculateHammingDistance(String leftStrand, String rightStrand) {
        int dist = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                dist++;
            }
        }
        return dist;
    }

}
