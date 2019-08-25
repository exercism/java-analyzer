class Hamming {

    private final String leftStrand;
    private final String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() == 0 && rightStrand.length() != 0)
            throw new IllegalArgumentException(("left strand must not be empty."));
        if (rightStrand.length() == 0 && leftStrand.length() != 0)
            throw new IllegalArgumentException(("right strand must not be empty."));
        if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException(
                    "leftStrand and rightStrand must be of equal length.");

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        char[]
                l = this.leftStrand.toCharArray(),
                r = this.rightStrand.toCharArray();
        int dist = 0;
        for (int i=0; i<l.length; i++) if (l[i] != r[i]) dist++;
        return dist;
    }

}
