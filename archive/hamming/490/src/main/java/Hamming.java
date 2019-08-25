class Hamming {
    private String left;
    private String right;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand == "" && rightStrand != "") {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand == "" && leftStrand != "") {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else {
            if (leftStrand.length() != rightStrand.length()) {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }
            left = leftStrand;
            right = rightStrand;
        }
    }

    int getHammingDistance() {
        if (left.length() == 0 && right.length() == 0) {
            return 0;
        } else if (left.equals(right)) {
            return 0;
        } else {
            //calculate the difference in the two strings
            int mismatchCount = 0;
            for (int i = 0; i < left.length(); i++) {
                if (left.charAt(i) != right.charAt(i)) {
                    mismatchCount++;
                }
            }
            return mismatchCount;
        }
    }

}
