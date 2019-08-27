class Hamming  {
    private String leftStrand, rightStrand;
    private int l, r;

    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        this.l = leftStrand.length();
        this.r = rightStrand.length();
        if (l !=r) {
            if (l == 0) {
                throw new IllegalArgumentException("left strand must not be empty.");
            } else if (r == 0) {
                throw new IllegalArgumentException("right strand must not be empty.");
            } else {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }
        }
    }

    int getHammingDistance() {
        int e = 0;
        if ( (l == r ) & (leftStrand.equals(rightStrand) == false)) {
            int i;
            for (i = 0; i < l; i++) {
                if (leftStrand.charAt(i) != rightStrand.charAt(i)) e++;
            }
        }
        return e;
    }

}
