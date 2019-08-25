class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        if(leftStrand.isEmpty() && rightStrand.isEmpty()){

        }else if(leftStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");

        }else if(rightStrand.isEmpty()){
            throw new IllegalArgumentException("right strand must not be empty.");
    
        }else{
            if(leftStrand.length() != rightStrand.length()){
                throw new IllegalArgumentException( "leftStrand and rightStrand must be of equal length.");
              
            }

        }
    }

    int getHammingDistance() {
        int hamming_distance = 0;
        
        for(int i=0; i<leftStrand.length(); i++){
            if(! (leftStrand.substring(i,i+1).equals(rightStrand.substring(i,i+1)))){
                hamming_distance++;

            }
        }

        return hamming_distance;
    }

}
