import java.util.stream.IntStream;

class Hamming {

    private String leftStrand;
    
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        if (leftStrand.length() == 0 && rightStrand.length() != 0)
        throw new IllegalArgumentException("left strand must not be empty.");
    else if (rightStrand.length() == 0 && leftStrand.length() != 0)
        throw new IllegalArgumentException("right strand must not be empty.");
    else if (leftStrand.length() != rightStrand.length())
        throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    int getHammingDistance() {
        return Math.toIntExact(IntStream.range(0, leftStrand.length()).filter(x->leftStrand.charAt(x) != rightStrand.charAt(x)).count());
    }

}
