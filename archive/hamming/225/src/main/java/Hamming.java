class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() == rightStrand.length()) {
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
        } else if (leftStrand == "") {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand == "") {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        int differenceCount = 0;
        for (int i = 0; i < this.leftStrand.length(); i++ ) {
            if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) {
                differenceCount++;
            }
        }
        return differenceCount;
    }

}
