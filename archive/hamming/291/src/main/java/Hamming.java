class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if( leftStrand.isEmpty() ){
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if( rightStrand.isEmpty() ){
            throw  new IllegalArgumentException("right strand must not be empty.");
        }
        if( leftStrand.length() != rightStrand.length() ){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance()  {
        int hammingDistance = 0;

        if(  leftStrand.length() == rightStrand.length()){
            for( int i = 0, j = 0; i < leftStrand.length() && j < rightStrand.length(); i++, j++){
                    if( leftStrand.charAt(i) != rightStrand.charAt(j) )
                        hammingDistance++;
                }
        }
      return hammingDistance;
    }

}
