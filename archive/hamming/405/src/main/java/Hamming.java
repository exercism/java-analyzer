import java.util.stream.IntStream;

class Hamming {

    private final int distance;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            if (leftStrand.isEmpty()) {
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            if (rightStrand.isEmpty()) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        distance = calculateHammingDistance(leftStrand.toCharArray(), rightStrand.toCharArray());
    }

    int getHammingDistance() {
        return distance;
    }

    private int calculateHammingDistance(char[] left, char[] right) {
        return (int) IntStream.range(0, left.length).filter(i -> left[i] != right[i]).count();
    }

}
