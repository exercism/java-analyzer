class Hamming {

    private String _leftStrand;
    private String _rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (rightStrand.isEmpty() && !leftStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        _leftStrand = leftStrand;
        _rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int dist = 0;
        for (int i = 0; i < _leftStrand.length(); i++) {
            if (_leftStrand.charAt(i) != _rightStrand.charAt(i)) {
                dist++;
            }
        }
        return dist;
    }

}
