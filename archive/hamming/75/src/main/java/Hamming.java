class Hamming {
    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int distance;
        String msg = "leftStrand and rightStrand must be of equal length.";
        distance = 0;

        // I couldn't figured out why this code doesn't throw exception???
        if(leftStrand.length() != rightStrand.length()){
           throw new IllegalArgumentException(msg);
        }

        for(int i = 0; i < leftStrand.length(); i++){
           if(leftStrand.charAt(i) != rightStrand.charAt(i)){
               distance++;
           }
        }

        return distance;
    }

}
