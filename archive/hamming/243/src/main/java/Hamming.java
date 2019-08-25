class Hamming {

  private char[] leftStrand;
  private char[] rightStrand;

  Hamming(String leftStrand, String rightStrand) {
    if (!leftStrand.isEmpty() && rightStrand.isEmpty()) {
      throw new IllegalArgumentException("right strand must not be empty.");
    }
    if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
      throw new IllegalArgumentException("left strand must not be empty.");
    }
    if (leftStrand.length() != rightStrand.length()) {
      throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }
    this.leftStrand = leftStrand.toCharArray();
    this.rightStrand = rightStrand.toCharArray();
  }

  int getHammingDistance() {
    int ct = 0;
    for (int i = 0; i < leftStrand.length; i++) {
      if (leftStrand[i] != rightStrand[i]) {
        ct++;
      }
    }
    return ct;
  }
}
