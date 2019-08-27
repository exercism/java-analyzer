import java.lang.IllegalArgumentException;

class Hamming {

    char[] left, right;

    Hamming(String leftStrand, String rightStrand) {
        int exceptionID = -1;
        String[] exceptions = { "left strand must not be empty.", "right strand must not be empty.",
                "leftStrand and rightStrand must be of equal length." };

        if (leftStrand.isEmpty() ^ rightStrand.isEmpty())
            exceptionID = leftStrand.isEmpty() ? 0 : 1;

        else if (leftStrand.length() != rightStrand.length())
            exceptionID = 2;

        if (exceptionID >= 0)
            throw new IllegalArgumentException(exceptions[exceptionID]);

        left = leftStrand.toCharArray();
        right = rightStrand.toCharArray();
    }

    int getHammingDistance() {
        int distance = 0;
        int length = left.length;
        for (int i = 0; i < length; i++) {
            if (left[i] != right[i])
                distance++;
        }

        return distance;
    }
}