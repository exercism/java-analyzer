class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        if (leftStrand.length() != rightStrand.length()) {
            throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        }
    }

  int getHammingDistance() {
        int sum = 0;
        for (int i = 0; i < this.leftStrand.length(); i++) {
            if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) {
                sum++;
            }
        }
        return sum;
    }

}
