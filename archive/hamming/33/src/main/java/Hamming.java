class Hamming {

    public String left ;
    public String right ;

    Hamming(String leftStrand, String rightStrand) {
        if ( leftStrand.length() == rightStrand.length())
        {

            left = leftStrand ;
            right = rightStrand ;
            getHammingDistance();

        }
        else if ( leftStrand.isEmpty())
        {
            throw new IllegalArgumentException("left strand must not be empty." ) ;
        }
        else if ( rightStrand.isEmpty())
        {
            throw new IllegalArgumentException("right strand must not be empty." ) ;
        }
        else {

            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length." ) ;

        }
    }


    int getHammingDistance() {

        int cpt = 0 ;
        for ( int i = 0; i < left.length() ; i++)
        {
            if ( left.charAt(i) != right.charAt(i))
            {
                cpt++;
            }
        }
        return cpt ;

    }


}
