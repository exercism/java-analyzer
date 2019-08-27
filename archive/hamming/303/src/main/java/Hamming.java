class Hamming {

    private String leftStrand, rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if((leftStrand.equals("")) && (!rightStrand.equals(""))) throw new IllegalArgumentException("left strand must not be empty.");
        if((rightStrand.equals("")) && (!leftStrand.equals(""))) throw new IllegalArgumentException("right strand must not be empty.");
        if(leftStrand.length() != rightStrand.length()) throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int mistakes = 0;
        for(int i = 0; i < leftStrand.length(); i++){
            if(leftStrand.charAt(i) != rightStrand.charAt(i)) mistakes++;
        }
        return mistakes;
    }

}
