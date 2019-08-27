class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand){
        this.validateInput(leftStrand, rightStrand);
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int hammingDistance = 0;
        for(int i = 0; i < this.leftStrand.length(); i++){
            if(this.leftStrand.charAt(i) != this.rightStrand.charAt(i))
                hammingDistance++;
        }
        return hammingDistance;
    }

    void validateInput(String leftStrand, String rightStrand)
    {
        if(leftStrand.length() == rightStrand.length())
            return;
        if(leftStrand.isEmpty())
            throw new IllegalArgumentException("left strand must not be empty.");
        if(rightStrand.isEmpty())
            throw new IllegalArgumentException("right strand must not be empty.");
        if(leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }
}

