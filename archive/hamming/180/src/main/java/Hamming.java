class Hamming {

    private String _left;
    private String _right;

    Hamming(String leftStrand, String rightStrand) {

        if(leftStrand.isEmpty() && !rightStrand.isEmpty() ) {

            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if(!leftStrand.isEmpty() && rightStrand.isEmpty() ) {

            throw new IllegalArgumentException("right strand must not be empty.");
        }
        
        if(leftStrand.length() != rightStrand.length() ) {

            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        _left = leftStrand;
        _right = rightStrand;
    }

    int getHammingDistance() {
        
        int distance = 0;
        for(int i = 0; i < _left.length(); ++i) {

            if(_left.charAt(i) != _right.charAt(i) ) {

                ++distance;
            }
        }

        return distance;
    }

}
