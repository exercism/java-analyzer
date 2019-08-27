class Hamming {

    private String leftStrand;
    private String rightStrand;

    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand == "" && rightStrand != "") {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand == "" && leftStrand != "") {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        char[] leftStrandChars = this.leftStrand.toCharArray();
        char[] rightStrandChars = this.rightStrand.toCharArray();
        int distance = 0;

        for(int i=0; i<leftStrandChars.length; i++) {
            if (leftStrandChars[i] != rightStrandChars[i]) {
                distance++;
            }
        }
        return distance;
    }
}
