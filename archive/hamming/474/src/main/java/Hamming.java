class Hamming {
    private char[] l;
    private char[] r;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && !rightStrand.isEmpty())
            throw new IllegalArgumentException("left strand must not be empty.");
        if (rightStrand.isEmpty() && !leftStrand.isEmpty())
            throw new IllegalArgumentException("right strand must not be empty.");
        if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

        l = leftStrand.toCharArray();
        r = rightStrand.toCharArray();
    }

    int getHammingDistance() {
        int hamming = 0;
        int len = l.length;

        for (int i = 0; i < l.length; i++) {
            if (l[i] != r[i]) hamming++;
        }

        return hamming;
    }

}
