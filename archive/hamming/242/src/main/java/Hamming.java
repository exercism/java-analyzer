class Hamming {
    private String leftStrand, rightStrand;

    public Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {
        checkInvalidInputArgument(leftStrand, rightStrand);

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    private void checkInvalidInputArgument(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && !rightStrand.isEmpty())
            throw new IllegalArgumentException("left strand must not be empty.");
        else if (rightStrand.isEmpty() && !leftStrand.isEmpty())
            throw new IllegalArgumentException("right strand must not be empty.");
        else if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    public int getHammingDistance() {
        int hammingDistance = 0;

        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i))
                hammingDistance++;
        }

        return hammingDistance;
    }
}
