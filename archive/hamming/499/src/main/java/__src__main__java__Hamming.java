import java.lang.IllegalArgumentException;

class Hamming {

    String leftStrand__;
    String rightStrand__;
    Hamming(String leftStrand, String rightStrand) {
        if ( leftStrand.length() != rightStrand.length() ){
            if ( leftStrand.length() == 0)
            {
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            else if ( rightStrand.length() == 0 )
            {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            else
            {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }
        }
        else
        {
            leftStrand__ = leftStrand;
            rightStrand__ = rightStrand;
        }
    }

    int getHammingDistance() {
        int iDifferences = 0;

        for( int i = 0; i < leftStrand__.length(); i ++) {
            iDifferences += ( leftStrand__.charAt(i) == rightStrand__.charAt(i) ) ? 0 : 1;
        }

        return iDifferences;
    }
}
