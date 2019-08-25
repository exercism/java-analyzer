class Hamming {

    private char[] leftStrand;
    private char[] rightStrand;
    private int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
            this.leftStrand = leftStrand.toCharArray();
            this.rightStrand = rightStrand.toCharArray();

            if (leftStrand.length() != rightStrand.length() && leftStrand == "") {
                throw new IllegalArgumentException(String.format("left strand must not be empty."));
            } else if (leftStrand.length() != rightStrand.length() && rightStrand == ""){
                throw new IllegalArgumentException(String.format("right strand must not be empty."));
            } else if (leftStrand.length() != rightStrand.length()){
                throw new IllegalArgumentException(String.format("leftStrand and rightStrand must be of equal length."));
            }
    }

    int getHammingDistance() {
        for (int i = 0, j= 0; i< leftStrand.length;i++,j++){
                if (leftStrand[i] != rightStrand[j]) hammingDistance++;
            }
        return hammingDistance;
    }

}
