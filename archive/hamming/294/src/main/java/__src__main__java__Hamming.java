class Hamming {

    private int hammingDistance = 0;
    Hamming(String leftStrand, String rightStrand) {

        if (leftStrand.length() != rightStrand.length()) {
            if (leftStrand.length() == 0)
                throw new IllegalArgumentException("left strand musn't be empty.");
            if (rightStrand.length() == 0)
                throw new IllegalArgumentException("right strand musn't be empty.");

            throw new IllegalArgumentException("Left and right strand must be of equal length.");
        }

        for (int i = 0; i < leftStrand.length(); i++)
        {
            if (leftStrand.charAt(i) != rightStrand.charAt(i))
                hammingDistance++;
        }
    }

    int getHammingDistance() {
        return hammingDistance;
    }

}