class Hamming {
    private String leftStrand;
    private String rightStrand;
    private final String leftStringEmptyErrorMessage = "left strand must not be empty.";
    private final String rightStringEmptyErrorMessage = "right strand must not be empty.";
    private final String NotEqualLengthErrorMessage = "leftStrand and rightStrand must be of equal length.";


    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException{


        if(leftStrand.length() == 0 && rightStrand.length() != 0){
            throw new IllegalArgumentException(leftStringEmptyErrorMessage);
        }
        if(rightStrand.length() == 0 && leftStrand.length() != 0){
            throw new IllegalArgumentException(rightStringEmptyErrorMessage);
        }
        if(rightStrand.length() != leftStrand.length()){
            throw new IllegalArgumentException(NotEqualLengthErrorMessage);
        }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {

        int HammingDistance = 0;
        for(int i = 0; i< leftStrand.length(); i++){
             if(rightStrand.charAt(i) != leftStrand.charAt(i)){
                 HammingDistance += 1;
            }

         }
        return HammingDistance;
    }

}
