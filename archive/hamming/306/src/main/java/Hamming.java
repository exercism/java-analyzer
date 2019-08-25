class Hamming {
    private String leftStrand, rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.equals("") && !rightStrand.equals("")){
            throw  new IllegalArgumentException("left strand must not be empty.");
        }else if(!leftStrand.equals("") && rightStrand.equals("")){
            throw new IllegalArgumentException("right strand must not be empty.");
        }


        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int dnaCount = 0;

        for(int i = 0; i < this.leftStrand.length(); i++){
            if(this.leftStrand.charAt(i) != this.rightStrand.charAt(i)){
                dnaCount++;
            }
        }

        return dnaCount;
    }

}
