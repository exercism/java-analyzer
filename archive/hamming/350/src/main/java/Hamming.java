class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        checkArgumentsCorrectness(leftStrand, rightStrand);

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    private void checkArgumentsCorrectness(String leftStrand, String rightStrand) {
        if(leftStrand.length() != rightStrand.length()){
            if(leftStrand.isEmpty()){
                throw new IllegalArgumentException("left strand must not be empty.");
            } else if(rightStrand.isEmpty()){
                throw new IllegalArgumentException("right strand must not be empty.");
            } else {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }
        }
    }


    int getHammingDistance() {
        int diff = 0;
        for(int i = 0; i < leftStrand.length(); i++ ){
            if(leftStrand.charAt(i) != rightStrand.charAt(i)){
                diff++;
            }
        }
        return diff;
    }

}
