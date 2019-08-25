class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String _leftStrand, String _rightStrand) {
        if (_leftStrand.length() == 0 && _rightStrand.length() > 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (_rightStrand.length() == 0 && _leftStrand.length() > 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (_leftStrand.length() != _rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        leftStrand = _leftStrand;
        rightStrand = _rightStrand;
    }

    int getHammingDistance() {
        int count = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)){
                count++;
            }
        }
        return count;
    }

}
