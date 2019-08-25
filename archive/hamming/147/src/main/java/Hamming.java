class Hamming {

    private String leftStrand , rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        validateInput();
        getHammingDistance();
    }

    void validateInput(){

        if(leftStrand.length() != rightStrand.length()){
            if (leftStrand.isEmpty())
                throw new IllegalArgumentException("left strand must not be empty.");
            if (rightStrand.isEmpty())
                throw new IllegalArgumentException("right strand must not be empty.");
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

    }

    int getHammingDistance() {
        int hammingDistance = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i))
                    hammingDistance++;
        }
        return hammingDistance;
    }

}
