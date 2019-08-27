import java.util.stream.IntStream;

class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if((leftStrand == null) || (rightStrand == null)) {
            throw new IllegalArgumentException("left and right strands can't be null.");
        }
        if((leftStrand.length() == 0) && (rightStrand.length() > 0)) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if((rightStrand.length() == 0) && (leftStrand.length() > 0)) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if(leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        return IntStream
                .range(0, leftStrand.length())
                .map(i -> leftStrand.charAt(i) != rightStrand.charAt(i) ? 1 : 0)
                .sum();
    }
}
