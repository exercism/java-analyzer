class Hamming {
    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand){
        checkStrands(leftStrand, rightStrand);
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() throws IllegalArgumentException {
        int hammingDistance = 0;
        int strandLength = leftStrand.length();

        for (int i = 0; i < strandLength; i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                hammingDistance++;
            }
        }
        return hammingDistance;
    }

    private void checkStrands(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length() && leftStrand.length() == 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (leftStrand.length() != rightStrand.length() && rightStrand.length() == 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }
}

class DifferentLengthException extends IllegalArgumentException {
    private String message = "leftStrand and rightStrand must be of equal length.";
    @Override
    public String getMessage() {
        return message;
    }
}
