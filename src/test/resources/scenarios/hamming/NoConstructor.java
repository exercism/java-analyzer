import java.util.stream.IntStream;

/** Must use a custom constructor that takes two strings. */
class Hamming {
    private final int hammingDistance;

    /** Not the right type params. */
    Hamming(int hammingDistance) {
        this.hammingDistance = hammingDistance;
    }

    int getHammingDistance() {
        return hammingDistance;
    }
}