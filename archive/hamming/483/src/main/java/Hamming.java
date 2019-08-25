class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        boolean bothEmpty = leftStrand.isEmpty() && rightStrand.isEmpty();
        if (leftStrand.isEmpty() && !bothEmpty) {
            throwExepction("left strand must not be empty.");
        }
        if (rightStrand.isEmpty() && !bothEmpty) {
            throwExepction("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throwExepction("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        int distance = 0;
        for (int index = 0; index < leftStrand.length(); index++) {
            if (leftStrand.charAt(index) != rightStrand.charAt(index)) {
                distance++;
            }
        }
        return distance;
    }

    private void throwExepction(String message) {
        throw new IllegalArgumentException(message);
    }

}
