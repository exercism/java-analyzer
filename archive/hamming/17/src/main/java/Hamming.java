class Hamming {
    final private String leftStrand;
    final private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {

        if (leftStrand.length() != rightStrand.length()) {
            if (leftStrand.isEmpty() || rightStrand.isEmpty()) {
                throw new IllegalArgumentException(leftStrand.isEmpty() ? "left strand must not be empty." : "right strand must not be empty.");
            } else {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {

        int count = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                count++;
            }
        }
        return count;

    }

}
