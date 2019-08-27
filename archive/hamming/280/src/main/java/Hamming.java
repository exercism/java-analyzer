class Hamming {

    private String left;
    private String right;

    public Hamming(String leftStrand, String rightStrand) {
        left = leftStrand;
        right = rightStrand;
        if (left.length() != right.length()) {
            if (left == "") {
                throw new IllegalArgumentException("left strand must not be empty.");
            } else if (right == "") {
                throw new IllegalArgumentException("right strand must not be empty.");
            } else {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }
        }
    }

    public int getHammingDistance() {
        int diff = 0;
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) != right.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }

}

