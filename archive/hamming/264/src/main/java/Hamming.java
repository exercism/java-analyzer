class Hamming {
    private final String leftStrand;
    private final String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        if ((leftStrand.isEmpty() && rightStrand.isEmpty()) || leftStrand.equals(rightStrand)) {
            return 0;
        } else if (leftStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        } else {
            final char[] leftStrandChars = leftStrand.toCharArray();
            final char[] rightStrandChars = rightStrand.toCharArray();
            int hammingDistance = 0;
            for (int i = 0; i < leftStrandChars.length; i++) {
                if (leftStrandChars[i] != rightStrandChars[i]) {
                    hammingDistance++;
                }
            }
            return hammingDistance;
        }
    }
}