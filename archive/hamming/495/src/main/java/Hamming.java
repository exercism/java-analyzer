class Hamming {

    private int leftStrandLength;
    private int rightStrandLength;
    private int hammingDistance;
    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {

        this.leftStrandLength = leftStrand.length();
        this.leftStrand = leftStrand;
        this.rightStrandLength = rightStrand.length();
        this.rightStrand = rightStrand;

        checkException();

        int hammingDistance = 0;

        for (int i = 0; i < leftStrandLength; i++)
            if (leftStrand.charAt(i) != rightStrand.charAt(i))
                hammingDistance++;
        this.hammingDistance = hammingDistance;
    }

    int getHammingDistance() {
        
        return hammingDistance;

    }

    private void checkException() {

        if (isNullOrWhitespace(leftStrand) && !isNullOrWhitespace(rightStrand))
            throw new IllegalArgumentException("left strand must not be empty.");

        if (isNullOrWhitespace(rightStrand) && !isNullOrWhitespace(leftStrand))
            throw new IllegalArgumentException("right strand must not be empty.");

        if (leftStrandLength != rightStrandLength)
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

    }

    private static boolean isNullOrWhitespace(String s) {

        return s == null || isWhitespace(s);

    }

    private static boolean isWhitespace(String s) {

        return s.trim().length() == 0;

    }

}
