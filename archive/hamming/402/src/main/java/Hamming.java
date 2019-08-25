class Hamming {
    String leftStrand;
    String rightStrand;
    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        if(rightStrand.length() != leftStrand.length()){
            if(leftStrand.length() == 0){
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            if(rightStrand.length() == 0){
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        int HammingDistance = 0;
        for (int i = 0; i < leftStrand.length() ; i++) {
            if(leftStrand.charAt(i) != rightStrand.charAt(i))
                HammingDistance++;
        }
        return HammingDistance;
    }

}
