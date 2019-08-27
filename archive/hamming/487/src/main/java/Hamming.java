import java.util.ArrayList;

class Hamming {

    private String left;
    private String right;

    Hamming(String leftStrand, String rightStrand) {
        // first check:
        if (leftStrand.length() == 0 && rightStrand.length() != 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (leftStrand.length() != 0 && rightStrand.length() == 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() < rightStrand.length() || leftStrand.length() > rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        // then assign:
        this.left = leftStrand;
        this.right = rightStrand;
    }

    int getHammingDistance() {
        int difference = 0;
        for (int i = 0; i < this.left.length(); i++) {
            if (this.left.charAt(i) != this.right.charAt(i)) {
                difference += 1;
            }
        }
        return difference;
    }

}
