import java.util.Arrays;

class Hamming {

    private final String leftStrand;
    private final String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        if(leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if(rightStrand.isEmpty() && !leftStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if(leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        char[] leftChars = leftStrand.toCharArray();
        char[] rightChars = rightStrand.toCharArray();

        int count = 0;
        for(int i = 0; i < leftChars.length; i++) {
            if(leftChars[i] != rightChars[i]) {
                count++;
            }
        }

        return count;
    }
}
