class Hamming {

    private String _leftStrand;
    private String _rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand == "" && rightStrand != "") {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (leftStrand != "" && rightStrand == "") {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        _leftStrand = leftStrand;
        _rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int distance = 0;

        if (_leftStrand.length() > 0) {
            for (int i = 0; i < _leftStrand.length(); i++) {
                if (_leftStrand.charAt(i) != _rightStrand.charAt(i)) {
                    distance++;
                }
            }
        }

        return distance;
    }

}
