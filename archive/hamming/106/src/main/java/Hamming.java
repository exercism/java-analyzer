class Hamming {

    private final String _leftStrand;
    private final String _rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (isEmpty(leftStrand) && !isEmpty(rightStrand)) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (!isEmpty(leftStrand) && isEmpty(rightStrand)) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (!isSameLength(leftStrand, rightStrand)) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        _leftStrand = leftStrand;
        _rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int distance = 0;
        int index = 0;
        char[] rightStrandChar = _rightStrand.toCharArray();

        for (char leftChar : _leftStrand.toCharArray()) {
            if (leftChar != rightStrandChar[index]){
                distance += 1;
            }
            index += 1;
        }

        return distance;
    }

    private boolean isSameLength(String leftStrand, String rightStrand) {
        return (leftStrand.length() == rightStrand.length());
    }

    private boolean isEmpty(String strand) {
        return strand.length() == 0;
    }
}
