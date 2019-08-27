import java.util.stream.IntStream;

class Hamming {

    private final int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        hammingDistance = calculateHammingDistance(leftStrand, rightStrand);
    }

    private int calculateHammingDistance(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (rightStrand.isEmpty() && !leftStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        return Math.toIntExact(IntStream.range(0, leftStrand.length()).filter(i -> leftStrand.charAt(i) != rightStrand.charAt(i)).count());
    }

    int getHammingDistance() {
        return hammingDistance;
    }

}
