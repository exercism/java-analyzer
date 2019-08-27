class Hamming {

  private String leftStrandString;
  private String rightStrandString;

    Hamming(String leftStrand, String rightStrand) {
      if(leftStrand.isEmpty() && !rightStrand.isEmpty()){
        throw new IllegalArgumentException("left strand must not be empty.");
      }

      if(rightStrand.isEmpty() && !leftStrand.isEmpty()){
        throw new IllegalArgumentException("right strand must not be empty.");
      }

      if(leftStrand.length() != rightStrand.length()){
        throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
      }
      leftStrandString = leftStrand;
      rightStrandString = rightStrand;
    }

    int getHammingDistance() {
      int hammingDistance = 0;

      for(int counter = 0; counter < this.leftStrandString.length(); counter++){
        if(this.leftStrandString.charAt(counter) != this.rightStrandString.charAt(counter)){
          hammingDistance++;
        }
      }

      return hammingDistance;
    }
}
