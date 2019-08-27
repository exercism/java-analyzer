class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        this.validateStrings();
    }

    private int getStrandLength(){
        return this.leftStrand.length();
    }

    private void validateStrings(){
        if(this.leftStrand.length() == this.rightStrand.length()){
            return;
        }

        if(this.leftStrand.length() == 0){
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if(this.rightStrand.length() == 0){
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    int getHammingDistance() {
        int hammingDistance = 0;

        for(int i = 0, strandLength = this.getStrandLength(); i < strandLength; i++){
            hammingDistance += (this.leftStrand.charAt(i) == this.rightStrand.charAt(i) ? 0 : 1);
        }
        return hammingDistance;
    }

}
