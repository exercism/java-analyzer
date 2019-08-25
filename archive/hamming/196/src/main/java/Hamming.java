class Hamming {

    private String leftStrand;
    private String rightStrand;

    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            // both strands being empty is allowed, however in case only one strand is empty
            //  we are required to throw a specific exception per strand
            if (leftStrand.isEmpty())
                throw new IllegalArgumentException("left strand must not be empty.");
            if (rightStrand.isEmpty())
                throw new IllegalArgumentException("right strand must not be empty.");
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    public int getHammingDistance() {
        int hDist = 0;
        for (int i = 0; i < leftStrand.length(); ++i) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                hDist++;
            }
        }
        return hDist;
    }

}
