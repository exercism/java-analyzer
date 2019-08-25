import java.util.stream.IntStream;

class Hamming {

    private final String leftStrand;
    private final String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() throws IllegalArgumentException {

        if (leftStrand.isEmpty() && rightStrand.isEmpty()) return 0;
        if (isEmptyOrNull(leftStrand)) throw new IllegalArgumentException("left strand must not be empty.");
        if (isEmptyOrNull(rightStrand)) throw new IllegalArgumentException("right strand must not be empty.");

        if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

        return (int) IntStream.range(0, leftStrand.length()).filter(i -> leftStrand.charAt(i) != rightStrand.charAt(i)).count();
    }

    boolean isEmptyOrNull(String s) {
        return ((s == null) || (s.isEmpty()));
    }

}
