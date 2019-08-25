class Hamming {

    int _distance = 0;
    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() > 0 && rightStrand.length() == 0)
            throw new IllegalArgumentException("right strand must not be empty.");
        if (leftStrand.length() == 0 && rightStrand.length() > 0)
            throw new IllegalArgumentException("left strand must not be empty.");
        if (rightStrand.length() != leftStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        for (int i=0; i < leftStrand.length(); i++)
            _distance += leftStrand.charAt(i) != rightStrand.charAt(i) ? 1 : 0;
    }

    int getHammingDistance() {
        return _distance;
    }

}
