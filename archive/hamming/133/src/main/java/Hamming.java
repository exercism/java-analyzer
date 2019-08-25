class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String left, String right) {
        if (left.length() == 0 && right.length() > 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (right.length() == 0 && left.length() > 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (left.length() != right.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        leftStrand = left;
        rightStrand = right;
    }

    int getHammingDistance() {
        int distance = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                distance ++;
            }
        }
        return distance;
    }
}
