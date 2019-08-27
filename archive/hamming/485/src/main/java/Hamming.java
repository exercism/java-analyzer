import java.util.stream.IntStream;

import static java.lang.String.format;

class Hamming {

    private final byte[] leftStrand;
    private final byte[] rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        validate(leftStrand, rightStrand);
        this.leftStrand = leftStrand.getBytes();
        this.rightStrand = rightStrand.getBytes();
    }

    private void validate(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && !rightStrand.isEmpty())
            throw empty("left");
        if (!leftStrand.isEmpty() && rightStrand.isEmpty())
            throw empty("right");
        if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    private IllegalArgumentException empty(String side) {
        return new IllegalArgumentException(format("%s strand must not be empty.", side));
    }

    int getHammingDistance() {
        return (int) IntStream.range(0, leftStrand.length)
                .boxed()
                .map(i -> leftStrand[i] == rightStrand[i])
                .filter(b -> !b)
                .count();
    }

}
