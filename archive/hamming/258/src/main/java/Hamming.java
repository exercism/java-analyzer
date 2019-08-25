class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        validateInput(leftStrand, rightStrand);
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int distance = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            if (rightStrand.charAt(i) != leftStrand.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    private void validateInput(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && rightStrand.isEmpty()) {
            return;
        }
        if (leftStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (rightStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (rightStrand.length() != leftStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }
}
