class Hamming {
    private char[] leftStrandArray;
    private char[] rightStrandArray;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && rightStrand.isEmpty()){
            // Do Nothing here 
            // Case is needed to get testNoDistanceBetweenEmptyStrands working
        } else if (leftStrand.isEmpty()){
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand.isEmpty()){
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (leftStrand.length() != rightStrand.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrandArray = leftStrand.toCharArray();
        this.rightStrandArray = rightStrand.toCharArray();
    }

    int getHammingDistance() {
        int count = 0;
        for (int i = 0; i < leftStrandArray.length;i++){
            if (leftStrandArray[i] != rightStrandArray[i]){
                count++;
            }
        }
        return count;
    }

}
