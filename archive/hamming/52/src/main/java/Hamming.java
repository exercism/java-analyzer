import java.util.stream.*;

class Hamming {
    String leftStrand;
    String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.validateStrands(leftStrand, rightStrand);

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    void validateStrands(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (rightStrand.isEmpty() && !leftStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftStrand.length() != rightStrand.length() ) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        int differenceCount = 0;

        for (int i = 0; i < this.leftStrand.length(); i++) {
            if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) {
                differenceCount++;
            }
        }

        return differenceCount;
    }

}
