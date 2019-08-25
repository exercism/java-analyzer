import java.util.Objects;

class Hamming {

    private final String leftStrand;
    private final String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        Objects.requireNonNull(leftStrand);
        Objects.requireNonNull(rightStrand);
        var leftLength = leftStrand.length();
        var rightLength = rightStrand.length();
        if ( leftLength == rightLength) {
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
        } else if (leftLength == 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightLength == 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        int differences = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i) ) {
                differences++;
            }
        }
        return differences;
    }

}
