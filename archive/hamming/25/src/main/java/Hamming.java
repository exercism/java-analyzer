class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {

        if (leftStrand.length() == 0 && rightStrand.length() > 0)
            throw new java.lang.IllegalArgumentException("left strand must not be empty.");

        if (leftStrand.length() > 0 && rightStrand.length() == 0)
            throw new java.lang.IllegalArgumentException("right strand must not be empty.");

        if (leftStrand.length() != rightStrand.length())
            throw new java.lang.IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() throws IllegalArgumentException {

        int hammingDistance = 0;
        String[] leftStrandArray = leftStrand.split("");
        String[] rightStrandArray = rightStrand.split("");

        for (int i = 0; i < leftStrand.length(); i++) {
            if (!leftStrandArray[i].equals(rightStrandArray[i]))
                hammingDistance++;
        }
        return hammingDistance;
    }

}
