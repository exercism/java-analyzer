class Hamming {
    private String leftStrand;
    private String rightStrand;

    public Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int counterOfDifferences = 0;
        if(leftStrand.length() == rightStrand.length()){
            for(int i = 0; i<leftStrand.length();i++){
                if(leftStrand.charAt(i) != rightStrand.charAt(i)){
                    counterOfDifferences++;
                }
            }
        }
        else if(leftStrand.length() == 0){
            throw new IllegalArgumentException("Error: left strand must not be empty.");
        }
        else if(rightStrand.length() == 0){
            throw new IllegalArgumentException("Error: right strand must not be empty.");
        }
        else{
            throw new IllegalArgumentException("Error: leftStrand and rightStrand must be of equal length.");
        }

        return counterOfDifferences;
    }
}
