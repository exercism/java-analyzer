class Hamming {
    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (!isOfEqualLength(leftStrand, rightStrand)){
            if(leftStrand.isEmpty()) {
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            if(rightStrand.isEmpty()) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        char[] left = this.leftStrand.toCharArray();
        char[] right = this.rightStrand.toCharArray();
        int count = 0;
        for (int i = 0; i < left.length; i++) {
            if(left[i] != right[i]) {
              count++;
            }
        }
        return count;
    }

    private boolean isOfEqualLength(String a, String b) {
        return a.length() == b.length();
    }
}
