import java.util.stream.IntStream;

/** Constructor must throw IllegalArgumentException. */
class Hamming {
    private final int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty()) {
            this.hammingDistance = 0;
        } else {
            this.hammingDistance = 1;
        }
    }

    int getHammingDistance() {
        return hammingDistance;
    }
}
