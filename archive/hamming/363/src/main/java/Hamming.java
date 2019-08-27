import java.util.Objects;

class Hamming {

    private final char[] right;
    private final char[] left;

    Hamming(String leftStrand, String rightStrand) {
        Objects.requireNonNull(leftStrand);
        Objects.requireNonNull(rightStrand);
        if (!rightStrand.isEmpty() && leftStrand.isEmpty())
            throw new IllegalArgumentException("left strand must not be empty.");
        if (!leftStrand.isEmpty() && rightStrand.isEmpty())
            throw new IllegalArgumentException("right strand must not be empty.");
        if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

        this.right = rightStrand.toCharArray();
        this.left = leftStrand.toCharArray();
    }

    int getHammingDistance() {
        int distance = 0;
        for (int i = 0; i < left.length; ++i) {
            if (left[i] != right[i])
                distance++;
        }

        return distance;
    }

}
