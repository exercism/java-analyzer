class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            String messageException = "leftStrand and rightStrand must be of equal length.";
            if(leftStrand.length() == 0) {
                messageException = "left strand must not be empty.";
            }
            if(rightStrand.length() == 0) {
                messageException = "right strand must not be empty.";
            }
            throw new IllegalArgumentException(messageException);
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int hammingDistance = 0;
        for(int i = 0; i < this.leftStrand.length(); i++) {
            if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) {
                hammingDistance++;
            }
        }
        return hammingDistance;
    }

}
