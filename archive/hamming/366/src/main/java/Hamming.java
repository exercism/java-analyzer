import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Hamming {
    private String leftStrand;
    private String rightStrand; 

    Hamming(String leftStrand, String rightStrand) {

        if(leftStrand.isEmpty() && !rightStrand.isEmpty())
            throw new IllegalArgumentException("left strand must not be empty.");
        if(rightStrand.isEmpty() && !leftStrand.isEmpty())
            throw new IllegalArgumentException("right strand must not be empty.");
        if(rightStrand.length() != leftStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        return IntStream.range(0, rightStrand.length())
                .map(i -> (rightStrand.charAt(i) != leftStrand.charAt(i)) ? 1 : 0)
                .reduce(0, (i, j) -> i + j);
    }

}
