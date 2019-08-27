class Hamming {
    private char[] leftS;
    private char[] rightS;

    Hamming(String leftStrand, String rightStrand) throws IllegalAccessException {
        parametersCheck(leftStrand, rightStrand);
        
        leftS = leftStrand.toCharArray();
        rightS = rightStrand.toCharArray(); 
    }

    int getHammingDistance() {
        int count = 0 ;
        for(int i = 0; i < leftS.length; i++){
            if(leftS[i] != rightS[i]){
                count++;
            }
        }

        return count;
    }

    void parametersCheck(String left, String right){
        if(left.isEmpty() && (right.length() > 0)) throw new IllegalArgumentException("left strand must not be empty.");
        if(right.isEmpty() && (left.length() > 0)) throw new IllegalArgumentException("right strand must not be empty.");
        if(left.length() != right.length()) throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

}
