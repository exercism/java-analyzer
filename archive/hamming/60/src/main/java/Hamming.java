class Hamming {


    private int distance = 0;
    private String leftStrand;
    private String rightStrand;
    Hamming(String leftStrand, String rightStrand) {

        if(leftStrand.length() == 0 && rightStrand.length() > 0){
            throw  new IllegalArgumentException("left strand must not be empty.");
        }
        else if(rightStrand.length() == 0 && leftStrand.length() > 0){
            throw  new IllegalArgumentException("right strand must not be empty.");
        }
        else if(leftStrand.length() != rightStrand.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        else{
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
        }

    }

    int getHammingDistance() {
        if(leftStrand.length() <= 0 && rightStrand.length() <= 0){
            return 0;
        } else if(leftStrand.equals(rightStrand)){
            return 0;
        } else {
            char[] leftStrandCharArray = leftStrand.toCharArray();
            char[] rightStrandCharArray = rightStrand.toCharArray();
            for(int i = 0; i < rightStrandCharArray.length; i++){
                if(leftStrandCharArray[i] != rightStrandCharArray[i]){
                    distance++;
                }
            }
            return distance;
        }
    }

}
