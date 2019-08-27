class Hamming {

    String leftStrand;
    String rightStrand;
    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        if (this.leftStrand.length() == 0 && this.rightStrand.length() != 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (this.leftStrand.length() != 0 && this.rightStrand.length() == 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (this.leftStrand.length() != this.rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        int diff = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                diff += 1;
            }
        }
        return diff;
    }
}
