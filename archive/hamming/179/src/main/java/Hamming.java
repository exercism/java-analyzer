class Hamming {

    private String leftInput;
    private String rightInput;

    Hamming(String leftStrand, String rightStrand) {
         leftInput = leftStrand;
         rightInput = rightStrand;
    }

    int getHammingDistance() throws IllegalArgumentException {

      if (leftInput.length() != rightInput.length()){

          throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
      }
      int hammingDistance = 0;
      int arrayCounter = 0;
      char[] rightInputArray = rightInput.toCharArray();
      for (char c:leftInput.toCharArray()){
       if (c != rightInputArray[arrayCounter]){
           hammingDistance += 1;
       }
       arrayCounter += 1;
      }
      return hammingDistance;

    }

}




