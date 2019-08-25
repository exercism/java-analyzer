class Hamming {

    private String leftStrand, rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        if (leftStrand.length() == 0 && rightStrand.length() > 0)
            throw new IllegalArgumentException("left strand must not be empty.");
        else if (rightStrand.length() == 0 && leftStrand.length() > 0)
            throw new IllegalArgumentException("right strand must not be empty.");
        else if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    int getHammingDistance() {

        int hammingDistance = 0;

        for (int i = 0; i < leftStrand.length(); i++) {
            char left = leftStrand.charAt(i);
            char right = rightStrand.charAt(i);
            if (left != right)
                ++hammingDistance;
        }

        return hammingDistance;
    }

}
