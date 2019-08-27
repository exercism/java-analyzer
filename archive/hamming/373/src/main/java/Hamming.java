class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        checkStrand();
    }

    private void checkStrand() {

        int leftLen = leftStrand.length();
        int rightLen = rightStrand.length();
        
        if (leftLen == 0 && rightLen != 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (leftLen != 0 && rightLen == 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftLen != rightLen) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        int count = 0;

        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) count++;
        }

        return count;
    }

}
