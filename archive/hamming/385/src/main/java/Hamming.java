import java.util.Arrays;
import java.util.List;

class Hamming {

    private final List leftStrand;
    private final List rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() == 0 & rightStrand.length() > 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand.length() == 0 & leftStrand.length() > 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.leftStrand = Arrays.asList(leftStrand.split(""));
        this.rightStrand = Arrays.asList(rightStrand.split(""));
    }

    int getHammingDistance() {
        int diff = 0;
        for (int i = 0; i < leftStrand.size(); i++) {
            if (!leftStrand.get(i).equals(rightStrand.get(i))) {
                diff++;
            }
        }
        return diff;
    }

}
