class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        String msg = "";

        if(leftStrand.length() != rightStrand.length()){
            if(leftStrand.length() == 0){
                msg = "left strand must not be empty.";
            }else if(rightStrand.length() == 0){
                msg = "right strand must not be empty.";
            }else{
                msg = "leftStrand and rightStrand must be of equal length.";
            }
            throw new IllegalArgumentException(msg);
        }else{
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
        }
    }

    int getHammingDistance() {
        int hammingDistance = 0;
        final int length = this.leftStrand.length();

        for(int i=0; i<length; i++){
            if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)){
                hammingDistance++;
            }
        }

        return hammingDistance;
    }

}
