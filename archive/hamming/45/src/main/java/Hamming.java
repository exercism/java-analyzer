class Hamming {
    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        if (this.leftStrand.length() == 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (this.rightStrand.length() == 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (this.leftStrand.length() != this.rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        if (leftStrand.equals(rightStrand)) return 0;
        else {
            int hamming = 0;
            for (int index=0; index < leftStrand.length(); index++) {
                if (leftStrand.charAt(index) != rightStrand.charAt(index)) {
                    hamming++;
                }
            }
            return hamming;
        }
    }

}
