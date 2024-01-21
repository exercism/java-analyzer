/** Constructor must have conditional logic. */
class Hamming {
    private final int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        this.hammingDistance = 0;
    }

    int getHammingDistance() {
        return hammingDistance;
    }
}
