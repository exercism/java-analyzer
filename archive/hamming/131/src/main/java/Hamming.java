import java.util.stream.IntStream;

class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        checkForOneEmptyStrand();
        checkForDifferentLengths();
    }

    private void checkForOneEmptyStrand() {
        if (leftStrand.length() + rightStrand.length() != 0) {
            if (leftStrand.equals("")) {
                throw new IllegalArgumentException("left strand must not be empty.");
            } else if (rightStrand.equals("")) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
        }
    }

    private void checkForDifferentLengths() {
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        return (int) IntStream.range(0, leftStrand.length()).filter(i -> leftStrand.charAt(i) != rightStrand.charAt(i)).count();
    }
}
