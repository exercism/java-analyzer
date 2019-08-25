class Hamming {

    private final int length;
    private final String leftStrand;
    private final String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        final int leftLength = this.leftStrand.length();
        final int rightLength = this.rightStrand.length();

        if (leftLength == 0 && rightLength > 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (leftLength > 0 && rightLength == 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftLength != rightLength) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.length = leftLength;
    }

    int getHammingDistance() throws IllegalArgumentException {
        int distance = 0;

        for (int i = 0; i < this.length; i++) {
            if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) {
                distance += 1;
            }
        }

        return distance;
    }

}
