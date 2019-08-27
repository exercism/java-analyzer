class Hamming {
    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand == "" && rightStrand != "") { throw new IllegalArgumentException("left strand must not be empty."); }
        if (rightStrand == "" && leftStrand != "") { throw new IllegalArgumentException("right strand must not be empty."); }
        if (leftStrand.length() != rightStrand.length()) { throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length."); }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        Integer countDifferences = 0;
        for (int i = 0; i < this.leftStrand.length(); i++) {
            if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) {
                countDifferences += 1;
            }
        }
        return countDifferences;
    }

}
