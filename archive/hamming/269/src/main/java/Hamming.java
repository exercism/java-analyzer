class Hamming {
    String[] leftChars;
    String[] rightChars;
    boolean isSet = false;
    int hammingDistance = 0;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.equals(rightStrand)) {
            setHammingDistance(0);
            return;
        }

        if (rightStrand.isEmpty())
            throw new IllegalArgumentException("right strand must not be empty.");

        if (leftStrand.isEmpty())
            throw new IllegalArgumentException("left strand must not be empty.");

        leftChars = leftStrand.split("");
        rightChars = rightStrand.split("");

        if (leftChars.length != rightChars.length)
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

    }

    // memoization
    int getHammingDistance() {
        if (!isSet) {
            setHammingDistance(calculateHammingDistance(leftChars, rightChars));
        }

        return hammingDistance;
    }

    // mutation
    void setHammingDistance(int distance) {
        hammingDistance = distance;
        isSet = true;
    }

    // utilities
    int calculateHammingDistance(String[] leftChars, String[] rightChars) {
        int total = 0;
        for (int i = 0; i < leftChars.length; i++)
            if (!leftChars[i].equals(rightChars[i]))
                total += 1;

        return total;
    }
}
