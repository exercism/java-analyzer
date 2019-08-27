import java.util.stream.IntStream;

class Hamming {

    private int hamming = 0;

    public Hamming(String left, String right) {

        String message = left.isEmpty() && !right.isEmpty() ? "left strand must not be empty." :
                         right.isEmpty() && !left.isEmpty() ? "right strand must not be empty." :
                         left.length() != right.length() ? "leftStrand and rightStrand must be of equal length." : "";

        if (!message.isEmpty()) {
            throw new IllegalArgumentException(message);
        } else {
            IntStream.range(0, left.length()).forEach(i -> hamming += left.charAt(i) != right.charAt(i) ? 1 : 0);
        }

    }

    public int getHammingDistance() {
        return hamming;
    }

}
