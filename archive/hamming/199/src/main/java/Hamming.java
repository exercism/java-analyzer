class Hamming {
    private String left;
    private String right;

    Hamming(String leftStrand, String rightStrand) {
      new HammingValidator(leftStrand, rightStrand).checkValidInput();
      
      left = leftStrand;
      right = rightStrand;
    }

    int getHammingDistance() {
      char[] leftBases = left.toCharArray();
      char[] rightBases = right.toCharArray();

      int differences = 0;

      for(int i = 0; i < leftBases.length; i++)
        if(leftBases[i] != rightBases[i]) differences++;

      return differences;
    }
}

class HammingValidator {
  private String left;
  private String right;

  HammingValidator(String leftStrand, String rightStrand) {
     left = leftStrand;
     right = rightStrand;
  }

  void checkValidInput() {
    if(left.isEmpty() && !right.isEmpty())
      throw new IllegalArgumentException("left strand must not be empty.");

    if(!left.isEmpty() && right.isEmpty())
      throw new IllegalArgumentException("right strand must not be empty.");

    if(left.length() != right.length())
      throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
  }
}
