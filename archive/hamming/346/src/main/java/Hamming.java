class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        validate(leftStrand, rightStrand);
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int distance = 0;
        for (int i = 0; i < this.leftStrand.length(); i++) {
            if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    private void validate(String leftStrand, String rightStrand) {
        boolean leftIsEmpty = leftStrand == null || leftStrand.isEmpty();
        boolean rightIsEmpty = rightStrand == null || rightStrand.isEmpty();
        if (leftIsEmpty && !rightIsEmpty) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (rightIsEmpty && !leftIsEmpty) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }
}
