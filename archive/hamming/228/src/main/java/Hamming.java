class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        verifyStrands();
    }

    int getHammingDistance() {
        String[] leftStrandArray = this.leftStrand.split("");
        String[] rightStrandArray = this.rightStrand.split("");

        int hammingDistance = 0;

        for (int i = 0; i < leftStrandArray.length; i++) {
            if (!(leftStrandArray[i].equals(rightStrandArray[i]))) {
                hammingDistance ++;
            }
        }

        return hammingDistance;
    }

    private void verifyStrands() {
        if (this.leftStrand.length() == 0 && !(this.rightStrand.length() == 0)) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (!(this.leftStrand.length() == 0) && this.rightStrand.length() == 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (!(this.leftStrand.length() == this.rightStrand.length())) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

}
