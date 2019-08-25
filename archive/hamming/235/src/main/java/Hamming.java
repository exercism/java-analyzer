class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        if (this.leftStrand.equals("") && !this.rightStrand.equals("")) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (this.rightStrand.equals("") && !this.leftStrand.equals("")) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (this.leftStrand.length() != this.rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        if (this.leftStrand.equals("") && this.rightStrand.equals("")) {
            return 0;
        }

        char[] leftStrandArray = this.leftStrand.toCharArray();
        char[] rightStrandArray = this.rightStrand.toCharArray();

        int distance = 0;

        for (int i = 0; i < this.leftStrand.length(); i++) {
            if (leftStrandArray[i] != rightStrandArray[i]) {
                distance++;
            }
        }

        return distance;

    }

}
