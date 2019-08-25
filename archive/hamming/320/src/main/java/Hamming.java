class Hamming {
    char[] leftStrand;
    char[] rightStrand;
    int result;

    Hamming(String leftStrand, String rightStrand) {
        handleExceptions(leftStrand, rightStrand);
        this.leftStrand = leftStrand.toCharArray();
        this.rightStrand = rightStrand.toCharArray();
    }

    int getHammingDistance() {
        int index = 0;
        for (char letter : this.leftStrand) {
            if (letter != this.rightStrand[index]) {
                this.result += 1;
            }
        index += 1;
        };
        return this.result;
    }

    private void handleExceptions(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            if (leftStrand.length() == 0) {
                throwException("left strand must not be empty.");
            }
            if (rightStrand.length() == 0 ) {
                throwException("right strand must not be empty.");
            }
            throwException("leftStrand and rightStrand must be of equal length.");
        };
    }

    private void throwException(String message) {
        throw new IllegalArgumentException(message);
    }
}