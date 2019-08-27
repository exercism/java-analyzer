class Hamming {
    String leftStrand, rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        validate(leftStrand, rightStrand);

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int distance = 0;

        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) distance++;
        }

        return distance;
    }

    private static void validate(String leftStrand, String rightStrand) {
        int leftStrandLength = leftStrand.length();
        int rightStrandLength = rightStrand.length();

        if (leftStrandLength == 0 && rightStrandLength > 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (rightStrandLength == 0 && leftStrandLength > 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftStrandLength != rightStrandLength) {
            throw new IllegalArgumentException(
                    "leftStrand and rightStrand must be of equal length."
            );
        }
    }

}