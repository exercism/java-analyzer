import java.util.stream.IntStream;

class Hamming {

    private char[] leftStrand;
    private char[] rightStrand;

    Hamming(String leftStrand, String rightStrand) {

        if (leftStrand.length() == 0 && rightStrand.length() > 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (rightStrand.length() == 0 && leftStrand.length() > 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.leftStrand = leftStrand.toCharArray();
        this.rightStrand = rightStrand.toCharArray();

    }

    int getHammingDistance() {
        return (int) IntStream.range(0, leftStrand.length)
                .filter(i -> leftStrand[i] != rightStrand[i])
                .count();
    }

}
