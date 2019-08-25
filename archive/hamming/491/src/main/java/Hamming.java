class Hamming {

    private final String _leftStrand;
    private final String _rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand == null || (leftStrand.isEmpty() && !rightStrand.isEmpty() ))
        {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (rightStrand == null || (rightStrand.isEmpty() && !leftStrand.isEmpty()))
        {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftStrand.length() != rightStrand.length())
        {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        _leftStrand = leftStrand;
        _rightStrand = rightStrand;
    }

    int getHammingDistance() {

        int result = 0;

        for (int i = 0; i < _leftStrand.length() ; i++)
        {
            if (_leftStrand.charAt(i) != _rightStrand.charAt(i))
            {
                result++;
            }
        }

        return result;
    }
}
