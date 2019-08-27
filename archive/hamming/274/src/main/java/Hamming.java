class Hamming {

    private String left;
    private String right;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            if (leftStrand.length() == 0)
                throw new IllegalArgumentException("left strand must not be empty.");

            if (rightStrand.length() == 0)
                throw new IllegalArgumentException("right strand must not be empty.");

            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.left = leftStrand;
        this.right = rightStrand;
    }

    int getHammingDistance() {
        int count = 0;
        for (int i = 0; i < left.length(); ++i) {
            if (left.charAt(i) != right.charAt(i))
                ++count;
        }

        return count;
    }

}
