class Hamming {

    private String left;
    private String right;
    private int distance = 0;
    private boolean bothStrandsEmpty;

    Hamming(String leftStrand, String rightStrand) {
        if ( leftStrand.isEmpty() && rightStrand.isEmpty() ) {
            bothStrandsEmpty = true;
        }

        if ( ( leftStrand.isEmpty() || rightStrand.isEmpty() ) && !bothStrandsEmpty ) {
            throw new IllegalArgumentException( ( ( leftStrand.isEmpty() ) ? "left" : "right" ) + " strand must not be empty." );
        }
        else if ( leftStrand.length() != rightStrand.length() ) {
            throw new IllegalArgumentException( "leftStrand and rightStrand must be of equal length." );
        }
        else {
            left = leftStrand;
            right = rightStrand;
        }
    }

    int getHammingDistance() {
        if ( bothStrandsEmpty ) return 0;

        for ( int i = 0; i < left.length(); i++ ) {
            if ( left.charAt( i ) != right.charAt( i ) ) {
                distance++;
            }
        }

        return distance;
    }

}
