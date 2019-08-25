class Hamming {

    private char[] leftStrand;
    private char[] rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand.toCharArray();
        this.rightStrand = rightStrand.toCharArray();

        if (this.leftStrand.length != this.rightStrand.length) {
            if (this.leftStrand.length == 0) {
                throw new IllegalArgumentException("left strand must not be empty.");
            } else if (this.rightStrand.length == 0) {
                throw new IllegalArgumentException("right strand must not be empty.");
            } else {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }
        }
    }

    int getHammingDistance() {
        int distance = 0;
        for (int i = 0; i < leftStrand.length; i++) {
            if (leftStrand[i] != rightStrand[i]) {
                distance++;
            }
        }
        return distance;
    }

}
