import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Hamming {


    public static final Set<Character> BASES = new HashSet<>(Arrays.asList('A', 'T', 'C', 'G'));

    private int distance;

    Hamming(String leftStrand, String rightStrand) {

        if (leftStrand.isEmpty() && rightStrand.length() > 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (rightStrand.isEmpty() && leftStrand.length() > 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        for (int i = 0; i < leftStrand.length(); i++) {
            if (!BASES.contains(leftStrand.toUpperCase().charAt(i)) || !BASES.contains(rightStrand.toUpperCase().charAt(i))) {
                throw new IllegalArgumentException("Bad input.");
            }
            if (rightStrand.charAt(i) != leftStrand.charAt(i)) {
                distance++;
            }
        }
    }

    int getHammingDistance() {
        return distance;
    }

}
