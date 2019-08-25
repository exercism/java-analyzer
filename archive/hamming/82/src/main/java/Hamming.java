class Hamming {

    private String _leftStrand;
    private String _rightStrand;

    Hamming(String leftStrand, String rightStrand) {

        if (leftStrand.length() > 0 && rightStrand.length() == 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftStrand.length() == 0 && rightStrand.length() > 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this._leftStrand = leftStrand;
        this._rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int distance = 0;

        char[] leftStrand = this._leftStrand.toCharArray();
        char[] rightStrand = this._rightStrand.toCharArray();

        for (int i = 0; i < leftStrand.length; i++) {
            distance += leftStrand[i] == rightStrand[i] ? 0 : 1;
        }

        return distance;
    }

}
