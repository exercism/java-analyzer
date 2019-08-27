class Hamming {

    private String rightStrand, leftStrand;

    Hamming(String leftStrand, String rightStrand) {
        if ((leftStrand == null || leftStrand.isEmpty()) && (rightStrand == null || rightStrand.isEmpty())) {
            this.rightStrand = "";
            this.leftStrand = "";
        } else if (leftStrand == null || leftStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand == null || rightStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (rightStrand.length() != leftStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        } else {
            this.rightStrand = rightStrand;
            this.leftStrand = leftStrand;
        }
    }

    int getHammingDistance() {
        int diff = 0;
        for (int i = 0; i < this.rightStrand.length(); i++) {
            if (this.rightStrand.charAt(i) != this.leftStrand.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }

}
