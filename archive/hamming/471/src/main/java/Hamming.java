import java.util.stream.IntStream;
import java.util.stream.Stream;

class Hamming {
    private String l;
    private String r;

    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.length() != rightStrand.length()){
            if(leftStrand.length() == 0)
                throw new IllegalArgumentException("left strand must not be empty.");
            if(rightStrand.length() == 0)
                throw new IllegalArgumentException("right strand must not be empty.");
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.l = leftStrand;
        this.r = rightStrand;
    }

    int getHammingDistance() {
        return (int) IntStream.range(0, this.l.length())
                .filter(i -> this.l.charAt(i) != this.r.charAt(i))
                .count();
    }
}
