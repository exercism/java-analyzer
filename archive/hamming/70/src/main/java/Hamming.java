class Hamming {
    private String _leftStrand;
    private String _rightStrand;
    private int _stringLength;

    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {
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
        _stringLength = leftStrand.length();
    }

    int getHammingDistance() {
        int hammingDistance = 0;

        for (int i = 0; i < _stringLength; i++) {
            if (_leftStrand.charAt(i) != _rightStrand.charAt(i)) {
                hammingDistance += 1;
            }
        }

        return hammingDistance;
    }

}
