class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {
        if (leftStrand.isEmpty() && !rightStrand.isEmpty())
            throw new IllegalArgumentException("left strand must not be empty.");
        if (!leftStrand.isEmpty() && rightStrand.isEmpty())
            throw new IllegalArgumentException("right strand must not be empty.");
        if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() throws IllegalArgumentException {

        int hammingDistance = 0;

        char [] arrLeftStrand = leftStrand.toCharArray();
        char [] arrRightStrand = rightStrand.toCharArray();

        for (int i = 0; i < arrLeftStrand.length ; i++) {
            if (arrLeftStrand[i] != arrRightStrand[i]) {
                hammingDistance++;
            }
        }

        return hammingDistance;

    }
}
