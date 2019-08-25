import java.util.stream.IntStream;

class Hamming {

    private int distance;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) 
            throw new IllegalArgumentException("left strand must not be empty.");

        if (rightStrand.isEmpty() && !leftStrand.isEmpty()) 
            throw new IllegalArgumentException("right strand must not be empty.");

        if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

        distance = (int) IntStream.range(0, leftStrand.length())
            .mapToObj(i -> new Object[]{leftStrand.charAt(i), rightStrand.charAt(i)})
            .filter(v -> v[0] != v[1])
            .count();
    }

    int getHammingDistance() {
        return distance;
    }

}
