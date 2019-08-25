class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
       if (leftStrand == "" && rightStrand != "") {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand == "" && leftStrand != "") {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (leftStrand.length() != rightStrand.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        } else {
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
        }
    }

    int getHammingDistance() {
        int hammingCount=0;
        for (int i=0; i<this.leftStrand.length(); i++) {
            if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) {
                hammingCount++;
            } else if (this.leftStrand=="" || this.rightStrand=="") {
                return 0;
            }
        }
        return hammingCount;
    }

}
