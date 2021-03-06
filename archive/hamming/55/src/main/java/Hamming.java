class Hamming {

  private String leftStrand;
  private String rightStrand;
  private int hammingDistance = 0;

  Hamming(String leftStrand, String rightStrand) {
    if (rightStrand.isEmpty() && !leftStrand.isEmpty()) {
      throw new IllegalArgumentException("right strand must not be empty.");
    } else if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
      throw new IllegalArgumentException("left strand must not be empty.");
    } else if (leftStrand.length() != rightStrand.length()) {
      throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }
    this.leftStrand = leftStrand;
    this.rightStrand = rightStrand;
  }

  int getHammingDistance() throws IndexOutOfBoundsException, IllegalArgumentException {
    for (int i = 0; i < leftStrand.length(); i++) {
      if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
        hammingDistance++;
      }
    }
    return hammingDistance;
  }

}
