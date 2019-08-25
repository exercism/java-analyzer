class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        validateStrands(leftStrand, rightStrand);
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand; 
    }

    public int getHammingDistance() {

        int distance = 0;
        for (int i = 0; i < getLeftStrand().length(); i++){
           if(getLeftStrand().charAt(i) != getRightStrand().charAt(i)) {
            distance += 1;
           }   
       }
       return distance;
   }

    private String getLeftStrand() {
        return this.leftStrand;
    }

    private String getRightStrand() {
    return this.rightStrand;
    }

   private void validateStrands(String leftStrand, String rightStrand) {
        checkForEmptyStrands(leftStrand, rightStrand);
        checkForEqualLength(leftStrand, rightStrand);
   }

   private void checkForEqualLength(String leftStrand, String rightStrand) {
        if(leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
   }

   private void checkForEmptyStrands(String leftStrand, String rightStrand) {
        if(!(leftStrand.isEmpty() && rightStrand.isEmpty())) {
            checkLeftStrand(leftStrand);
            checkRightStrand(rightStrand);
        }
   }

   private void checkLeftStrand(String leftStrand) {
       if(leftStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
       }
   }

   private void checkRightStrand(String rightStrand) {
        if(rightStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
    }

}
