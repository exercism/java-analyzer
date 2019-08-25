import java.util.Objects;

import static java.util.Objects.nonNull;

class Hamming {

    private final String leftStrand;
    private final String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (nonNull(leftStrand) && nonNull(rightStrand)) {
            validateArguments(leftStrand, rightStrand);
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
        } else {
            throw new IllegalArgumentException("leftStrand or rightStrand can not be null.");
        }
    }

    private void validateArguments(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            if (leftStrand.isEmpty()) {
                throw new IllegalArgumentException("left strand must not be empty.");
            } else if (rightStrand.isEmpty()) {
                throw new IllegalArgumentException("right strand must not be empty.");
            } else {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }
        }
    }

    int getHammingDistance() {
        if (Objects.equals(leftStrand, rightStrand)) {
            return 0;
        } else {
            char[] leftStrandArray = leftStrand.toCharArray();
            char[] rightStrandArray = rightStrand.toCharArray();
            int hammingDistance = 0;
            for (int i = 0; i < leftStrandArray.length; i++) {
                if (leftStrandArray[i] != rightStrandArray[i]) {
                    hammingDistance += 1;
                }
            }
            return hammingDistance;
        }
    }

}
