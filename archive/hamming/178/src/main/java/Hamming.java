import java.util.Objects;

class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        throwExceptionIfDistanceIsNotEqual(leftStrand, rightStrand);
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {

        int totalDistance = 0;
        char[] leftStrandArray = leftStrand.toCharArray();
        char[] rightStrandArray = rightStrand.toCharArray();

        for(int i=0; i< leftStrandArray.length; i++){
            if(leftStrandArray[i] != rightStrandArray[i]){
                totalDistance++;
            }
        }
        return totalDistance;
    }

    void throwExceptionIfDistanceIsNotEqual(String leftStrand, String rightStrand) {

        if(Objects.isNull(leftStrand) || Objects.isNull(rightStrand)){
            throw new IllegalArgumentException("left or right strand must not be null.");
        }

        int diffLength = leftStrand.length() - rightStrand.length();

        if(diffLength != 0){

            String exceptionMessage ="leftStrand and rightStrand must be of equal length.";

            if(leftStrand.isEmpty() || rightStrand.isEmpty()){
                exceptionMessage = String.format("%s strand must not be empty.", leftStrand.isEmpty() ? "left" : "right");
            }

            throw new IllegalArgumentException(exceptionMessage);
        }

    }

}
