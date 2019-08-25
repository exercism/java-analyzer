class Hamming {
  private final String leftStrand;
  private final String rightStrand;

  Hamming(String leftStrand, String rightStrand) {
    validate(leftStrand, rightStrand);
    this.leftStrand = leftStrand;
    this.rightStrand = rightStrand;
  }

  int getHammingDistance() {
    int hammingDistance = 0;
    for (int i = 0; i < leftStrand.length(); i++) {
      if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
        hammingDistance++;
      }
    }
    return hammingDistance;
  }

  private void validate(String leftStrand, String rightStrand) {
    if (leftStrand.isEmpty() && rightStrand.isEmpty()) {
      return; //Hack for passing the test
      //throw new IllegalArgumentException("Both strands must not be empty.");
    }
    if (leftStrand.isEmpty()) {
      throw new IllegalArgumentException("left strand must not be empty.");
    }
    if (rightStrand.isEmpty()) {
      throw new IllegalArgumentException("right strand must not be empty.");
    }
    if (leftStrand.length() != rightStrand.length()) {
      throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }
  }
}
