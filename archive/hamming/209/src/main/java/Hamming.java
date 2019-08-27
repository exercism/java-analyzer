class Hamming {

    String leftStrand;
    String rightStrand;

    Hamming(String leftStrand, String rightStrand) {

        // check parameters

        // empty strings only forbidden if only one of two is empty,
        // both empty is okay and needed for tests;
        // but then with one empty string and the other not empty,
        // one string is always shorter, so there would be an
        // exception thrown anyway for the different length?!?
        if (leftStrand.isEmpty() && !rightStrand.isEmpty())
            throw new IllegalArgumentException(
                    "left strand must not be empty.");

        if (rightStrand.isEmpty() && !leftStrand.isEmpty())
            throw new IllegalArgumentException(
                    "right strand must not be empty.");

        if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException(
                    "leftStrand and rightStrand must be of equal length.");

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {

        // equal Strings have difference 0
        if (leftStrand.equals(rightStrand))
            return 0;

        int hamming = 0;
        // compare strings
        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i))
                hamming++;
        }

        return hamming;

    }

}
