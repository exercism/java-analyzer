class Hamming {

    private final String _leftStrand;
    private final String _rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.length() != rightStrand.length()){
            String msg;

            if(leftStrand.length() == 0)
              msg = "left strand must not be empty.";
            else if(rightStrand.length() == 0)
              msg = "right strand must not be empty.";
            else
              msg = "leftStrand and rightStrand must be of equal length.";

            throw new IllegalArgumentException(msg);
        }
        _leftStrand = leftStrand;
        _rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int dist = 0;
        for(int i = 0; i < _leftStrand.length(); i++ )
        {
            if(_leftStrand.charAt(i) != _rightStrand.charAt(i))
              dist++;
        }
        return dist;
    }

}
