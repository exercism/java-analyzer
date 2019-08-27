class Hamming {

    private String rightStrand;
    private String leftStrand;

    Hamming(String leftStrand, String rightStrand) {
        catchErrors(leftStrand, rightStrand);
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int count = 0;
        for(int i =0; i < this.leftStrand.length(); i++) {
            if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) count++;
        }
        return count;
    }

    void catchErrors(String left, String right) {
        if (left.length() < 1 && right.length() > 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (right.length() < 1  && left.length() > 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (left.length() != right.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

}
