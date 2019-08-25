class Hamming {
    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        validateStrands(leftStrand, rightStrand);
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int hammingDistance = 0;
        for (int index = 0; index < leftStrand.length(); index++) {
            if(leftStrand.charAt(index) != rightStrand.charAt(index)) {
                hammingDistance++;
            }
        }
        return hammingDistance;
    }

    private void validateStrands(String leftStrand, String rightStrand) {
        if(leftStrand.length() != rightStrand.length()) {
            String message = "leftStrand and rightStrand must be of equal length.";
            if(leftStrand.length() == 0) {
                message = "left strand must not be empty.";
            } else if(rightStrand.length() == 0) {
                message = "right strand must not be empty.";
            }
            throwException(message);
        }
    }

    private void throwException(String message) {
        throw new IllegalArgumentException(message);
    }

}
