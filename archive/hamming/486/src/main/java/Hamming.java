class Hamming {

  private final String leftStrand;
  private final String rightStrand;

  Hamming(String leftStrand, String rightStrand) {
    if (leftStrand == null || leftStrand.isEmpty()) {
      throw new IllegalArgumentException("left strand must not be empty.");
    }
    if (rightStrand == null || rightStrand.isEmpty()) {
      throw new IllegalArgumentException("right strand must not be empty.");
    }
    if (leftStrand.length() != rightStrand.length()) {
      throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }
    this.leftStrand = leftStrand;
    this.rightStrand = rightStrand;
  }

  int getHammingDistance() {
    int distance = 0;
    for (int i = 0; i < rightStrand.length(); i++) {
      if (rightStrand.charAt(i) != leftStrand.charAt(i)) {
        distance += 1;
      }
    }
    return distance;
  }
}
