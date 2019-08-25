class Hamming {
    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand){
        //Constructor for a hamming
        validateInput(leftStrand,rightStrand);
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }
    void validateInput(String leftStrand, String rightStrand){
        if(leftStrand.length() != rightStrand.length()){
            if(leftStrand.isEmpty()){
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            else if(rightStrand.isEmpty()){
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            throw new IllegalArgumentException("both leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        int hammingDistance = 0;

        //Increments through both strands at the same time to compare characters at same i index value
        for(int i =0; i < leftStrand.length(); i++){
            if(leftStrand.charAt(i) != rightStrand.charAt(i)){
                hammingDistance++;
            }
        }
        return hammingDistance;
    }

}
