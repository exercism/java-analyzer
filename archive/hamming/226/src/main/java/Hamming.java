class Hamming {

    private String leftStrand, rightStrand;

    Hamming(String leftStrand, String rightStrand) {

        boolean leftEmpty = leftStrand == null || leftStrand.isEmpty();
        boolean rightEmpty = rightStrand == null || rightStrand.isEmpty();

        if (leftEmpty ^ rightEmpty) {
            throw new IllegalArgumentException(String.format("%s strand must not be empty.", leftEmpty ? "left" : "right"));
        }

        if (rightStrand.length() != leftStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {

        int dist = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            char left = leftStrand.charAt(i);
            char right = rightStrand.charAt(i);
            if (left != right) {
                dist++;
            }
        }

        return dist;
    }

}
