class Hamming {

    private int strandSize;
    private char[] left, right;

    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {
        if(leftStrand == "" ^ rightStrand == ""){
            if (leftStrand == "") throw new IllegalArgumentException("left strand must not be empty.");
            if (rightStrand == "") throw new IllegalArgumentException("right strand must not be empty.");
        }
        if(leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.strandSize = leftStrand.length();
        this.left = leftStrand.toCharArray();
        this.right = rightStrand.toCharArray();
    }

    int getHammingDistance() {
        int diff = 0;
        for(int idx = 0; idx < strandSize; idx++) {
            if(left[idx] != right[idx]) {
                diff++;
            }
        }
        return diff;
    }
}
