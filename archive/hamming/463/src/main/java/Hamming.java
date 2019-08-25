class Hamming {
    private int distance_ = 0;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && rightStrand.isEmpty()) {
            distance_ = 0;
        } else if (leftStrand.isEmpty()) {
            String what = "left strand must not be empty.";
            throw new IllegalArgumentException(what);
        } else if (rightStrand.isEmpty()) {
            String what = "right strand must not be empty.";
            throw new IllegalArgumentException(what);
        } else if (leftStrand.length() != rightStrand.length()) {
            String what = "leftStrand and rightStrand must be of equal length.";
            throw new IllegalArgumentException(what);
        }
        for (int i = 0; i < leftStrand.length(); ++i) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                ++distance_;
            }
        }
    }

    int getHammingDistance() {
        return distance_;
    }

}
