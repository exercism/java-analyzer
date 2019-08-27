class Hamming {
    String left;
    String right;

    Hamming(String leftStrand, String rightStrand) {
        this.left = leftStrand;
        this.right = rightStrand;

        if (left.length() != right.length()) {
            if (left.isEmpty()) {
                throw new IllegalArgumentException("left strand must not be empty.");
            } else if (right.isEmpty()) {
                throw new IllegalArgumentException("right strand must not be empty.");
            } else throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        int counter = 0;
        
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) != right.charAt(i)) {
                counter++;
            }
        }
        return counter;
    }
}
