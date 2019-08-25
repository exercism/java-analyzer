class Hamming {

    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.length() != rightStrand()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        if(leftStrand == null){
            throw new IllegalArgumentException("leftStrand must not be empty.");
        }
        if(rightStrand == null){
            throw new IllegalArgumentException("rightStrand must not be empty.");
        }
        int hammingDistance;
        char[] leftStrandChar = leftStrand.toCharArray();
        char[] rightStrandChar = rightStrand.toCharArray();
        for(int i = 0; i < leftStrandChar.length; i ++){
            if(leftStrandChar[i] != rightStrandChar[i])
                hammingDistance++;

        }
        return hammingDistance;

    }

    int getHammingDistance() {


}
