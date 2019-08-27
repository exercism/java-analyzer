class Hamming {

    String leftStrand;
    String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        int leftStrandLength = leftStrand.length();
        int rightStrandLength = rightStrand.length();
        if (leftStrandLength != rightStrandLength) {
            if (leftStrandLength == 0) {
                throw new IllegalArgumentException("left strand must not be empty.");
            } else if (rightStrandLength == 0) {
                throw new IllegalArgumentException("right strand must not be empty.");
            } else {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int result = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                result++;
            }
        }
        return result;
    }

}
