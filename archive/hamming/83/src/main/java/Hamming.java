class Hamming {

    private String left;
    private String right;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() == 0 && rightStrand.length() > 0){
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand.length() == 0 && leftStrand.length() > 0){
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (leftStrand == null || rightStrand == null || leftStrand.length() != rightStrand.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }



        this.left = leftStrand;
        this.right = rightStrand;
    }

    int getHammingDistance() {
        int count = 0;
        char[] lChar = left.toCharArray();
        char[] rChar = right.toCharArray();
        for (int i = 0; i < lChar.length; i++){
            if (lChar[i] != rChar[i]){
                count++;
            }
        }
        return count;

    }

}
