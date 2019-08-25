class Hamming {
    String leftStrand;
    String rightStrand;

    Hamming(String lStrand, String rStrand) {
        if (lStrand.length() != rStrand.length()) {
            if (lStrand.length() == 0)
                throw new IllegalArgumentException("left strand must not be empty.");
            else if (rStrand.length() == 0)
                throw new IllegalArgumentException("right strand must not be empty.");
            else
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        leftStrand = lStrand;
        rightStrand = rStrand;
    }

    int getHammingDistance() {
        int count = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i))
                count++;
        }
        return count;
    }
}
