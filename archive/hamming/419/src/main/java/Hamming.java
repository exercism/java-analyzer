class Hamming {

    private String[] left;
    private String[] right;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.equals("") && rightStrand.equals("")) {
            // strangely this case is okay even though individually they must not be empty
            // so do nothing here
        }
        else if (leftStrand.equals("")) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        else if (rightStrand.equals("")) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        left = leftStrand.split("");
        right = rightStrand.split("");
    }

    int getHammingDistance() {
        int result = 0;
        for (int i = 0; i < left.length; i ++) {
            if (!left[i].equals(right[i])) {
                result++;
            }
        }

        return result;
    }

}
